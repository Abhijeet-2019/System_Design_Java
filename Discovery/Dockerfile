FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Discovery.jar
ENTRYPOINT ["java","-jar","ROOT .jar"]
EXPOSE 8761