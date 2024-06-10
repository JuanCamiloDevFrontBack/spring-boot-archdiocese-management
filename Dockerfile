FROM maven:3.9.2-eclipse-temurin-17-alpine AS builder
COPY ./pom.xml pom.xml
COPY ./src src/
RUN mvn clean package -DskipTest
FROM eclipse-temurin:17-jre-alpine
COPY --from=builder target/*.jar app.jar
EXPOSE 8001
ENTRYPOINT [ "java", "-jar", "app.jar" ]