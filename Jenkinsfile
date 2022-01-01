pipeline {
    agent any
     environment {
            ARTIFACT_NAME = 'spring-security.jar'
            AWS_S3_BUCKET = '10prashhanthn'
            AWS_EB_APP_NAME = 'springSecurity'
            AWS_EB_ENVIRONMENT = 'Prashhanth-env-1'
            AWS_EB_APP_VERSION = "${BUILD_ID}"
        }
    stages {
        stage('npm') {
            steps {
                sh 'npm --version'
            }
        }
        stage('ng') {
            steps {
                sh 'ng --version'
            }
        }
       stage('change dir') {
            steps {
                dir("${env.WORKSPACE}/src/main/resources/ang"){
                sh "npm i --legacy-peer-deps"
                sh "ls"
               }
            }
        }
       stage('back-to-main-dir') {
           steps {
               dir("${env.WORKSPACE}"){
               sh "mvn clean install"
             }
           }
       }
       stage('Deploy'){
          steps{
            dir("${env.WORKSPACE}"){
               sh "pwd"
               sh "aws s3 cp ./target/spring-security.jar s3://10prashhanthn/spring-security${env.BUILD_ID}.jar"
               sh "aws elasticbeanstalk create-application-version --application-name prashhanth --version-label v.0.${env.BUILD_ID} --source-bundle S3Bucket=10prashhanthn,S3Key=spring-security${env.BUILD_ID}.jar"
               sh "aws elasticbeanstalk update-environment --application-name prashhanth --environment-name Prashhanth-env --version-label v.0.${env.BUILD_ID}"
              }
          }
       }
    }
   post {
     always {
         //mail bcc: '', body: "<b>Profile Project</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "prashhanth.nelakanti@gmail.com";
         cleanWs notFailBuild: true
     }
   }
}


//aws elasticbeanstalk update-environment --environment-name Prashhanth-env-1 --application-name spring-security --version-label v2
//aws elasticbeanstalk create-application-version --application-name $AWS_EB_APP_NAME --version-label $AWS_EB_APP_VERSION --source-bundle S3Bucket=$AWS_S3_BUCKET,S3Key=$ARTIFACT_NAME