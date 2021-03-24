#Dockerfile contains all the commands with which
#Docker can build images reading the instructions.

FROM openjdk:11

ADD ./target/user-service.jar /usr/src/user-service.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "user-service.jar"]