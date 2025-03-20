# Step 1: Build Stage
# Use Maven 3.9.6 with JDK 21 for the build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the application and skip tests
RUN mvn clean package -DskipTests

# Step 2: Runtime Stage
# Download and use Early Access JDK 23 from OpenJDK builds
FROM ubuntu:22.04

# Set the working directory for runtime
WORKDIR /app

# Install required packages (wget, curl, etc.)
RUN apt-get update && apt-get install -y wget curl unzip

# Download and install JDK 23 EA build
RUN wget https://download.java.net/java/early_access/jdk23/13/GPL/openjdk-23-ea+13_linux-x64_bin.tar.gz \
    && tar -xvzf openjdk-23-ea+13_linux-x64_bin.tar.gz \
    && mv jdk-23 /usr/local/java23 \
    && rm openjdk-23-ea+13_linux-x64_bin.tar.gz

# Set JAVA_HOME to the installed JDK 23 path
ENV JAVA_HOME="/usr/local/java23"
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Copy the built JAR from the build stage to the runtime container
COPY --from=build /app/target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar

# Expose port 8080
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
