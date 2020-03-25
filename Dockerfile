FROM openjdk:11

VOLUME /tmp
COPY target/*.jar /polls.jar

#ENTRYPOINT java -jar polls.jar

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://polls-database/test","-Djava.security.egd=file:/dev/./urandom","-jar","/polls.jar"]


