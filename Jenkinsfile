pipeline {

  environment {
    dockerimagename = "janescience/check-duplicate-service"
    dockerImage = ""
  }

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git 'https://github.com/Janescience/check-duplicate-service.git'
      }
    }

    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

    stage('Pushing Image') {
      environment {
               registryCredential = 'docker-credential'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }

    stage('Deploying spring cloud check-duplicate-service container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yml", "service.yml")
        }
      }
    }

  }

}