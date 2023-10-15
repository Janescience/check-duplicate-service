#! /bin/sh
# source ~/.bash_profile
mvn clean package
docker build -t check-duplicate-service .
docker rm -f check-duplicate-service
docker rmi $(docker images -qa -f 'dangling=true')
docker run -d --name check-duplicate-service -p 8085:8085 check-duplicate-service