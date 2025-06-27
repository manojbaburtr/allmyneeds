# Use official Java image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy your project files into the container
COPY . .

# Make Maven Wrapper executable
RUN chmod +x mvnw

# Build the project (skip tests to make it faster)
RUN ./mvnw clean package -DskipTests

# Start the Spring Boot app
CMD ["java", "-jar", "target/SimpleLoginApp-0.0.1-SNAPSHOT.jar"]