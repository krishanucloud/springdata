pipeline {
  environment {
    registry = "krishanucloud/spring-data"
    registryCredential = 'dockerhub-id'
    dockerImage = ''
    dockerImageLatest = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git branch: 'main',
          credentialsId: 'github-id',
          url: 'https://github.com/krishanucloud/springdata.git'
      }

    }
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Building Docker Image') {
      steps {
        script {
          echo pwd
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
          dockerImageLatest = dockerImage
        }
      }
    }
    stage('Push Image to Docker Hub') {
      steps {
        script {
          docker.withRegistry('', registryCredential) {
            dockerImage.push()
            dockerImageLatest.push('latest')
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps {
        sh "docker rmi $registry:$BUILD_NUMBER"
        sh "docker rmi $registry:latest"

      }
    }

  }
}