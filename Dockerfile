FROM openjdk:19
LABEL maintainer="javaguides.net"
ADD target/authenticatie-0.0.1-SNAPSHOT.jar AuthenticatieBack.jar
ENTRYPOINT ["java","-jar","AuthenticatieBack.jar"]