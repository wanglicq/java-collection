pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'Hello'
            }
        }
        stage('test'){
            steps {
                sh './gradlew test jacocoTestReport'
                jacoco()
            }
        }
    }


}