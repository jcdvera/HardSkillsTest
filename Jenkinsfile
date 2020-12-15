pipeline {
    agent any

    stages {
        stage('Prepare WireMock') {
            steps {
                echo "wiremock"
            }
        }
        stage('Run Automated Tests') {
            steps {
                sh "mvn clean test"
            }
        }
    }
    post {
        always {
            cucumber (fileIncludePattern: '**/cucumber.json', jsonReportDirectory: 'target')
            deleteDir()
        }
    }
}