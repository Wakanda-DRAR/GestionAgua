FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/GestionAgua-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]