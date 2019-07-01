pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './quickstart/gradlew build --console verbose -p quickstart/'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Assemble') {
            steps {
                sh './quickstart/gradlew assemble -p quickstart/'
            }
        }
        stage('Unit_Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}