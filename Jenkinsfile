pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Janescience/check-duplicate-service']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t janescience/check-duplicate-service:latest .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u janescience -p ${dockerhubpwd}'
                    }
                    sh 'docker tag check-duplicate-service:latest janescience/check-duplicate-service:latest'
                    sh 'docker push janescience/check-duplicate-service:latest'
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

