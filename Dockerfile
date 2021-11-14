FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/timesheet-devops-2-1.0.jar timesheet-devops-2-1.0.jar
ENTRYPOINT ["java","-jar","/timesheet-devops-2-1.0.jar"]