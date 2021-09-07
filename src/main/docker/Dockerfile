#FROM java:8
FROM openjdk:11
VOLUME /tmp
COPY ureport-demon-1.0-SNAPSHOT.jar test.jar
RUN bash -c "touch /test.jar"
ENTRYPOINT ["java","-jar","test.jar"]