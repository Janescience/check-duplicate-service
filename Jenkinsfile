pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    environment {
        DOCKER_HOME = '/usr/local/bin/docker'  // Path to the Docker executable
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-pwd')
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Janescience/check-duplicate-service']]])
                sh 'mvn clean install'
            }
        }
        stage('Build image'){
            steps{
                script{
                    sh '${DOCKER_HOME} build -t janescience/check-duplicate-service:latest .'
                }
            }
        }
        
        stage('Push image to Hub'){
            steps{
                script{
                    sh '${DOCKER_HOME} login -u janescience -p Top2233223233'
                    sh '${DOCKER_HOME} tag check-duplicate-service:latest janescience/check-duplicate-service:latest'
                    sh '${DOCKER_HOME} push janescience/check-duplicate-service:latest'
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'k8s/deployment.yml',kubeconfigId: 'k8sconfigpwd')
                    kubernetesDeploy (configs: 'k8s/service.yml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}

