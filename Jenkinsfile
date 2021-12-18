pipeline {
    agent any
    environment {
            AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
            AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
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
             post {
                 success {
                     archiveArtifacts 'target/*.jar'
                     sh 'aws configure set region us-east-1'
                     sh 'aws s3 cp ./target/spring-security.jar s3://10prashhanthn/spring-security.jar'
                 }
             }
           }
       }
    }
}

