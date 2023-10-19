# Check Duplicate Service

Microservice in Eureka Server (Spring Cloud)

## Prerequire

- Java 17++
- Maven
- Docker (Use for run with Docker)
- kubectl (Use for deploy kubernates)

## Run Local

Require Java 17++ and Maven installed on local

`mvn spring-boot:run`

## Run with Docker

If run with Docker not require Java & Maven

`docker build -t check-duplicate-service .`

`docker run -d --name check-duplicate-service -p 8085:8085 check-duplicate-service`

## Build .jar

File .jar output to /target

`mvn clean package`

## Deploy Kubernetes

Require 
- Config `kubectl` connect to Kubernetes Engine Server 
- If use Kubernetes in local just install `minikube` on local and `minikube` need to run with Docker

`kubectl apply -f /k8s/deployment.yml`

`kubectl apply -f /k8s/service.yml`

