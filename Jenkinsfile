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
                jacoco deltaBranchCoverage: '99', deltaClassCoverage: '99', deltaComplexityCoverage: '99', deltaLineCoverage: '99', deltaMethodCoverage: '99', minimumBranchCoverage: '99', minimumClassCoverage: '99', minimumComplexityCoverage: '99', minimumLineCoverage: '99', minimumMethodCoverage: '99'
            }
        }
    }


}