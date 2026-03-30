# Use valid OpenJDK 17 slim image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy your Spring Boot jar
COPY target/rentu-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]