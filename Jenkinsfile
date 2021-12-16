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
                sh "ng serve"
            }
        }
       stage('back-to-main-dir') {
            steps {
                dir("${env.WORKSPACE}"){
                sh "mvn clean install"
            }
        }
     }
  }   
}
