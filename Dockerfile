FROM maven:3.9.9-eclipse-temurin-23 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk-slim
COPY --from=build /target/car_management-0.0.1-SNAPSHOT.jar car_management.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
