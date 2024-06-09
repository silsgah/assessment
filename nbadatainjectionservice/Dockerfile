FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} nbadatainjectionservice.jar

ENTRYPOINT ["java","-jar","/nbadatainjectionservice.jar"]

EXPOSE 8080