FROM openjdk:23-jdk AS build
# Use JDK 17 directly to build and run
# FROM openjdk:17-jdk-slim

# Copy the project to the container
COPY . .

# Build and package using Maven
RUN ./mvnw clean package -DskipTests

# Copy the generated JAR to a new location
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
