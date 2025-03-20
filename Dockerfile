# Stage 1: Build with JDK 23
FROM amazoncorretto:23 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run with JDK 23
FROM amazoncorretto:23
WORKDIR /app
COPY --from=build /app/target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
