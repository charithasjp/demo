pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials') // Docker Hub credentials ID
        DOCKER_IMAGE = 'charithasjp/wiyamana'
        IMAGE_TAG = 'latest'
    }
    stages {
        stage('Checkout Code') {
            steps {
                // Pull code from GitHub
                checkout scm
            }
        }
        stage('Build Application') {
            steps {
                // Build the application (e.g., using Maven)
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build the Docker image
                sh "docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} ."
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // Login to Docker Hub and push the image
                    sh "echo ${DOCKER_HUB_CREDENTIALS_PSW} | docker login -u ${DOCKER_HUB_CREDENTIALS_USR} --password-stdin"
                    sh "docker push ${DOCKER_IMAGE}:${IMAGE_TAG}"
                }
            }
        }
    }
    post {
        always {
            echo 'Cleaning up...'
            deleteDir()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs for errors.'
        }
    }
}
