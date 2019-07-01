pipeline {
    agent any 
    stages {
        stage('Assemble') { 
            steps {
                echo 'Compiling.'
                sh './quickstart/gradlew assemble -p quickstart'
                archiveArtifacts 'quickstart/build/libs/*.jar'
            }
        }
        stage('Tests') {
            parallel {
                stage('Unit Tests 1') { 
                    steps {
                        echo 'Executing Unit Tests.'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                    post {
                        always {
                            junit "quickstart/build/test-results/test/*.xml"
                            archiveArtifacts 'quickstart/build/reports/tests/test/*'
                        }
                    }
                }
                stage('Unit Tests 2') { 
                    steps {
                        echo 'Executing Unit Tests.'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                }
            }
        }
        
        stage('Deploy') { 
            steps {
                echo 'Deploying.'
            }
        }
    }

    post {
        always {
            echo 'This is a post action.'
        }
    }
}