FROM openjdk:latest
LABEL authors="jvdon"
VOLUME /tmp
EXPOSE 8080
ADD ./target/ms-consultas-0.0.1-SNAPSHOT.jar msconsultas.jar
ENTRYPOINT ["java", "-jar", "/msconsultas.jar"]