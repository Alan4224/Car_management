# Sử dụng image Maven với JDK 22
FROM maven:3.9.9-amazoncorretto-23-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Sử dụng image OpenJDK 22 để chạy ứng dụng
FROM openjdk:23-slim
WORKDIR /app
COPY --from=build /app/target/car_management-0.0.1-SNAPSHOT.jar app.war
EXPOSE 8080
CMD ["java", "-jar", "app.war"]
