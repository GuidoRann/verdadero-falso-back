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

# Cambiar a .jar si es el tipo de archivo que se genera
COPY --from=build /app/target/vof-0.0.1-SNAPSHOT.jar drcomputer.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "drcomputer.jar"]
