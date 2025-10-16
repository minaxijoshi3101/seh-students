FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/seh-students-0.0.1-SNAPSHOT.jar .

# Copy SSL certificates (keystore + truststore)
COPY src/main/resources/seh-students.p12 .
COPY src/main/resources/internal-truststore.jks .

# Expose HTTPS port
EXPOSE 8443

# Run the Spring Boot app
CMD ["java", "-jar", "seh-students-0.0.1-SNAPSHOT.jar"]
