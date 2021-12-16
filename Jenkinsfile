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
       stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
