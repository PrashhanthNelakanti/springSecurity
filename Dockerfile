FROM openjdk:8
EXPOSE 8083
ADD target/spring-security.jar spring-security.jar
ENTRYPOINT ["java","-jar","/spring-security.jar"]