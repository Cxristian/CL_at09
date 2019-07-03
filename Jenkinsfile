pipeline {
    agent any 
    stages {
        stage('Assemble') { 
            steps {
                echo 'Compiling...'
                sh './quickstart/gradlew assemble -p quickstart'
                archiveArtifacts 'quickstart/build/libs/*.jar'
            }
        }
        stage('Tests') {
            parallel {
                stage('Unit Tests 1') { 
                    steps {
                        echo 'Executing Unit Test 1.'
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
                        echo 'Executing Unit Test 2.'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                }
            }
        }

        stage('Checks') { 
            steps {
                echo 'Deploying.'
            }
        }

        stage('Deploy') { 
            steps {
                echo 'Executing Checks.'
                sh './quickstart/gradlew check -p quickstart/'
            }
        }
    }

    post {
        always {
            echo 'This is a post action.'
            mail to: 'Cristian.lujan@fundacion-jala.org',
                 subject: "Test Pipeline: ${currentBuild.fullDisplayName}",
                 body: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
        }
    }
}
