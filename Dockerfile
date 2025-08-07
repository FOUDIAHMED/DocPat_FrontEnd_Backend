FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /DocPat
COPY target/DocPat-0.0.1-SNAPSHOT.jar /DocPat/DocPat.jar
EXPOSE 8080
CMD [ "java", "-jar", "DocPat.jar"]