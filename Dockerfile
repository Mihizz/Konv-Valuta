FROM openjdk:11-jre-slim
WORKDIR /app
COPY dist/KonvertorValuta.jar /app/
CMD ["java", "-jar", "KonvertorValuta.jar"]