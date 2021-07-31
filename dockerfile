FROM amazoncorretto:11-alpine-jdk
MAINTAINER Prasadh
COPY target/id-service-0.0.1.jar id-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/id-service-0.0.1.jar"]