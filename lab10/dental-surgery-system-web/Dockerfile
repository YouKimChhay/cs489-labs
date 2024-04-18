FROM openjdk:21-slim
RUN mkdir /app
COPY target/dental-surgery-system-web-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "./dental-surgery-system-web-0.0.1-SNAPSHOT.jar"]