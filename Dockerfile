FROM openjdk:8
EXPOSE 8083
ADD target/security-0.0.1-SNAPSHOT.jar security-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/security-0.0.1-SNAPSHOT.jar"]