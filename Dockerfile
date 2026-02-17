FROM openjdk:20-ea-13
COPY target/*.jar .
CMD ["java","-jar","*.jar"]
EXPOSE 3000