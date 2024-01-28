pipeline {
    agent any

    tools {
      maven 'maven'
      git 'git'
    }
    
    stages {
        stage('checkout') {
            steps {
                git branch: 'main', credentialsId: 'git_credentials', url: 'https://github.com/IsmaelSacko-py/devOpsProject_devOpsRoad.git'
            }
        }

        stage('compile') {
            steps {
                powershell 'mvn compile'
            }
        }

        stage('package') {
            steps {
                powershell 'mvn compile'
            }
        }

        stage('sonarqube') {
            steps {
                withSonarQubeEnv(credentialsId: 'SonarQube-Token', installationName: 'SonarQube') {
                    powershell 'mvn clean verify sonar:sonar -Dsonar.projectKey=Test-Scan'
                }
            }
        }

        stage('hello') {
            steps {
                echo "Hello world"
            }
        }
    }
}
