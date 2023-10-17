FROM maven:3.8.7-openjdk-17-slim AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests
FROM openjdk:18-jdk
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build  ${JAR_FILE} /home/app/build/check-duplicate.jar
ENTRYPOINT ["java","-jar","/home/app/build/check-duplicate.jar"]
EXPOSE 8085
