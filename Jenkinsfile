pipeline {
    
    agent any

    tools {
      maven 'maven'
      git 'git'
    }
    
    stages {
        stage('checkout SCM') {
            steps {
                git branch: 'main', credentialsId: 'git_credentials', url: 'https://github.com/IsmaelSacko-py/devOpsProject_devOpsRoad.git'
            }
        }

        stage('compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('sonarqube analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'SonarQube-Token', installationName: 'SonarQube') {
                    bat "mvn clean verify sonar:sonar -Dsonar.projectKey=Test-Scan -Dsonar.projectName='Test-Scan'"
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
