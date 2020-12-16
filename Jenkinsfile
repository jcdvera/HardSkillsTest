pipeline {
    agent any

    stages {
        stage('Prepare WireMock') {
            steps {
                echo "preparing wiremock"
                sh "chmod +x src/main/resources/wiremockRunner.sh"
                sh "src/main/resources/wiremockRunner.sh"
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