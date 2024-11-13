# Build stage
FROM maven:3.9.9-amazoncorretto-17-alpine AS build
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-slim
WORKDIR /app

COPY --from=build /app/target/car_management-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "drcomputer.war"]
