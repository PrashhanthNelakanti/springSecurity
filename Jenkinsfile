pipeline {
    agent any
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
          stage{
            dir("${env.WORKSPACE}"){
               sh "pwd"
               sh 'aws s3 cp ./target/spring-security.jar s3://10prashhanthn/spring-security1.jar'
              }
          }
       }
    }
}

