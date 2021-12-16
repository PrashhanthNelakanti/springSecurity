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
                sh "cd ${env.WORKSPACE}/src"
                sh 'pwd'
            }
        }
       node {
    stage("Test") {
        sh script:'''
          #!/bin/bash
          echo "This is start $(pwd)"
          mkdir hello
          cd ./hello
          echo "This is $(pwd)"
        '''
    }
}
    }
}
