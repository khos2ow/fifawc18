FROM openjdk:8-jre-alpine

RUN apk add --no-cache curl

ADD fifawc18-*.jar app.jar

EXPOSE 8080 9000

HEALTHCHECK --interval=10s --timeout=3s --start-period=10s CMD curl -f http://localhost:9000/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-Dprofiles.active=prod", "/app.jar"]
