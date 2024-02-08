FROM openjdk:17
ADD target/jpademo.jar jpademo.jar
expose 8080
ENTRYPOINT ["java", "-jar","jpademo.jar"]