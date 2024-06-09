FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} nbaservice.jar

ENTRYPOINT ["java","-jar","/nbaservice.jar"]

EXPOSE 8080