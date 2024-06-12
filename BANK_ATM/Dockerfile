FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bank-atm-service.jar
ENTRYPOINT ["java","-jar","ROOT .jar"]
EXPOSE 8082