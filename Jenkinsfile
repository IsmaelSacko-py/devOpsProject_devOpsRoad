pipeline {  
    agent any

    tools {
      maven 'maven'
      git 'git'
    }

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "localhost:8081"
        NEXUS_REPOSITORY = "devOpsRoad-central-repository"
        NEXUS_CREDENTIAL_ID = "Nexus-Token"
    }
    
    stages {
        stage('checkout SCM') {
            steps {
                git branch: 'main', credentialsId: 'git_credentials', url: 'https://github.com/IsmaelSacko-py/devOpsProject_devOpsRoad.git'
            }
        }

        stage('build') {
            steps {
                bat 'mvn clean compile package'
            }
        }

        stage('sonarqube analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'SonarQube-Token', installationName: 'SonarQube') {
                    bat "mvn clean verify sonar:sonar -Dsonar.projectKey=Test-Scan -Dsonar.projectName='Test-Scan' -Pcoverage"
                }
            }
        }
    }
}
