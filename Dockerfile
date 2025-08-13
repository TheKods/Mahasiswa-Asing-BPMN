# Stage 1: Build
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy pom.xml dan source code
COPY pom.xml .
COPY src ./src

# Build aplikasi tanpa menjalankan test
RUN mvn clean package -DskipTests

# Stage 2: Production
FROM openjdk:17-slim
WORKDIR /app

# Copy artifact dari stage build
COPY --from=build /app/target/pendaftaran-mahasiswa-asing-1.0.0-SNAPSHOT.jar app.jar

# Konfigurasi environment
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENV SPRING_PROFILES_ACTIVE=production

# Expose port
EXPOSE 8080

# Healthcheck
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Jalankan aplikasi
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"] 