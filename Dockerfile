# Use an official Gradle image to build the app
FROM gradle:7.6.0-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy only the build files first to leverage Docker's caching mechanism
COPY build.gradle settings.gradle ./

# Download and cache Gradle dependencies
RUN gradle build --no-daemon --stacktrace || return 0

# Copy the entire project (source code, resources, etc.)
COPY . .

# Build the Spring Boot application without running tests
RUN gradle bootJar --no-daemon --stacktrace

# Use a smaller image with JDK to run the Spring Boot app
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory for the runtime container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the Spring Boot app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
