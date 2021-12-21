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
                dir("${env.WORKSPACE}/src/main/resources/ui/app"){
                sh "npm install"
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
               sh 'aws s3 cp ./target/spring-security.jar s3://10prashhanthn/spring-security1.jar'
               //sh "aws elasticbeanstalk create-application-version --application-name ${AWS_EB_APP_NAME}--version-label ${AWS_EB_APP_VERSION} --source-bundle S3Bucket=${AWS_S3_BUCKET},S3Key=${ARTIFACT_NAME}"
               sh "aws elasticbeanstalk update-environment --application-name ${AWS_EB_APP_NAME} --environment-name ${AWS_EB_ENVIRONMENT} --version-label ${AWS_EB_APP_VERSION}"
              }
          }
       }
    }
}

