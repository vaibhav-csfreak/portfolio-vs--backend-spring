# Build stage (using JDK 23 Early Access)
FROM eclipse-temurin:23_35-jdk-jammy AS build
RUN apt-get update && apt-get install -y maven
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:23_35-jdk-jammy
COPY --from=build /target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "portfolio.jar"]