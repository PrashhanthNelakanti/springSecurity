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
                sh "cd ${env.WORKSPACE}/src/main/resources/ui/app/src"
                sh 'pwd'
            }
        }
       stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
