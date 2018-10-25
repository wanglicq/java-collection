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
                jacoco deltaBranchCoverage: '99', deltaClassCoverage: '99', deltaComplexityCoverage: '99', deltaLineCoverage: '99', deltaMethodCoverage: '99', minimumBranchCoverage: '95', minimumClassCoverage: '95', minimumComplexityCoverage: '95', minimumLineCoverage: '95', minimumMethodCoverage: '95'
            }
        }
    }


}