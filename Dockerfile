FROM openjdk:18-jdk
RUN mkdir /app
COPY ./target/voos-0.0.1-SNAPSHOT.jar /app/voos-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "voos-0.0.1-SNAPSHOT.jar"