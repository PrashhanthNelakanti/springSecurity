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
       stage('install nodemodules') {
            steps {
                dir("${env.WORKSPACE}/src"){
                sh "pwd"
            }
        }
      
    }
}
