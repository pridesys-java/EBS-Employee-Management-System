pipeline {
    agent any

    tools {
        jdk 'jdk-21'        // must be configured in Jenkins
        maven 'maven-3'     // must be configured in Jenkins
    }

    environment {
        APP_NAME = "pridesys-ebs"
        PORT = "8080"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pridesys-java/pridesys-ebs.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $APP_NAME .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh '''
                docker stop $APP_NAME || true
                docker rm $APP_NAME || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d -p $PORT:$PORT --name $APP_NAME $APP_NAME
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build & Deployment Successful'
        }
        failure {
            echo '❌ Build Failed'
        }
    }
}