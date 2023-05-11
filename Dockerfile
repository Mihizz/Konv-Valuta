FROM openjdk:11-jre-slim
WORKDIR /app
COPY KonvertovanjeValuta/target/KonvertorValuta.jar /app/
CMD ["java", "-jar", "KonvertorValuta.jar"]