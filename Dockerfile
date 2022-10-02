FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} money-service.jar
ENTRYPOINT ["java", "-jar", "/money-service.jar"]
CMD ["-start"]
EXPOSE 8000