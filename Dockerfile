FROM openjdk:20-ea-13
COPY target/*.jar .
CMD ["Java","-jar","*.jar"]
EXPOSE 5001