FROM maven:3.9.8-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21.0.4
COPY --from=build app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
