FROM openjdk:17-oracle
WORKDIR /app
ARG JAR_FILE=target/grpc-service-2.6.2.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]