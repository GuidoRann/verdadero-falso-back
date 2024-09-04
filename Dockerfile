# Build stage
FROM openjdk:21-slim AS build
WORKDIR /app

# Instalar Maven manualmente
RUN apt-get update && \
    apt-get install -y maven

COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /app/target/DrComputer-0.0.1-SNAPSHOT.war drcomputer.war
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "drcomputer.war"]
