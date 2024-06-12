FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-atm-service.jar
ENTRYPOINT ["java","-jar","ROOT .jar"]
EXPOSE 8084