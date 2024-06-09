FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} aggregateservice.jar

ENTRYPOINT ["java","-jar","/aggregateservice.jar"]

EXPOSE 8082