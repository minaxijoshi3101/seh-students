FROM openjdk:21-ea-17
COPY target/*.jar /app.jar
RUN mkdir -p /data/seh-pv/logs && chmod -R 777 /data/seh-pv/logs
EXPOSE 3000
CMD ["java","-jar","/app.jar"]
