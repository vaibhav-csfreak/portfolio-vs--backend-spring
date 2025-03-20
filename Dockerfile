FROM openjdk:23-jdk AS build
COPY . .
RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
entrypoint ["java","-jar","portfolio.jar"]

