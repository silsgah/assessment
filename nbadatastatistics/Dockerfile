FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} nbadatastatistics.jar

ENTRYPOINT ["java","-jar","/nbadatastatistics.jar"]

EXPOSE 8082