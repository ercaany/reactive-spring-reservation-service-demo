FROM openjdk:15
ADD target/reservation-service-0.0.1-SNAPSHOT.jar reservation-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /reservation-service.jar