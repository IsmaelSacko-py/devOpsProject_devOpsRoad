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
        NEXUS_REPOSITORY = "maven-central-repository"
        NEXUS_CREDENTIAL_ID = "Nexus-Token"
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
                bat 'mvn clean package'
            }
        }

        stage("Publish to Nexus Repository Manager") {
            steps {
                nexusArtifactUploader artifacts: [[artifactId: 'devOpsProject_devOpsRoad', classifier: 'debug', file: 'devOpsProject_devOpsRoad.jar', type: 'jar']], credentialsId: 'Nexus-Token', groupId: 'sn.devOpsRoad', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-central-repository', version: '1.0-SNAPSHOT'
            }
        }
    }
}
