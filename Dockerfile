FROM openjdk:17-jdk
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} /usr/local/webapps/check-duplicate.jar
ENTRYPOINT ["java","-jar","/usr/local/webapps/check-duplicate.jar"]
EXPOSE 8085
