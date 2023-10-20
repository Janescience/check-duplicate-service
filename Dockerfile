FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} check-duplicate.jar
ENTRYPOINT ["java","-jar","check-duplicate.jar"]
EXPOSE 8085
