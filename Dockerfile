FROM openjdk:21-ea-17
COPY target/*.jar /app.jar
EXPOSE 3000
CMD ["java","-jar","/app.jar"]
