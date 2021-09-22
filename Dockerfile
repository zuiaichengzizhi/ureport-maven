FROM registry.elitescloud.com/library/openjdk11-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ./target/*.jar /app.jar

ENV JAVA_OPTS=$JAVA_OPTS
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Xmn1024m -Xmx2048m /app.jar " ]
