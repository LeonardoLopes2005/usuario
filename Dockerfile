FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/usuario-0.0.1-SNAPSHOT.jar /app/usuario.jar

EXPOSE 7979

CMD ["java", "-jar", "/app/usuario.jar"]