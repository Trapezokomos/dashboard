# Use a base image that has Java installed
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file produced by the Spring Boot build process
COPY build/libs/*.jar app.jar

COPY . /app

COPY .env /app/.env

COPY prometheus/prometheus.yml /app/prometheus.yml

# Expose the port that your application runs on
EXPOSE 8080

# Define the command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
