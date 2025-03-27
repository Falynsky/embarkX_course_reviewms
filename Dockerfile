FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/reviewms-0.0.1-SNAPSHOT.jar reviewms-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "reviewms-0.0.1-SNAPSHOT.jar"]