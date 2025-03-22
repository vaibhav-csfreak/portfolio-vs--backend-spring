FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
