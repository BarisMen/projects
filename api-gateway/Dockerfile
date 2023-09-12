# Base image
FROM  openjdk:17

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 1111

# Run the application
CMD ["java", "-jar", "app.jar"]

