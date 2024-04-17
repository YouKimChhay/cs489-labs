FROM openjdk:21-slim
RUN mkdir /app
COPY target/helloworlddocker-1.0-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "./helloworlddocker-1.0-SNAPSHOT.jar"]