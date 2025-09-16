# 🚀 SEH Students Spring Boot Application

![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)

A **Spring Boot** application for managing student information. The app exposes **REST APIs** to interact with student data.

---

## 📁 Git Repository

Clone the repository:

```bash
git clone https://github.com/minaxijoshi3101/seh-students.git
cd seh-students
```

## 🗂 Folder Structure

```
seh-students/
├── src/
│   ├── main/
│   │   ├── java/com/example/sehstudents/   # Java source code
│   │   └── resources/
│   │       └── application.properties      # Spring Boot configuration
│   └── test/                               # Test classes
├── target/                                 # Compiled JAR files
├── Dockerfile                              # Docker build file
└── pom.xml                                 # Maven configuration
```
## 🛠 Build the Application

Build the project using **Maven**:

```bash
mvn clean package
```
The JAR file will be available in the target folder.

## 🐳 Docker

### Dockerfile

```dockerfile
# Base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/seh-students-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 3000

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
```

### 🛠 Build Docker Image
```bash
docker build -t seh-students:latest .
```
### Push Docker Image
```bash
docker tag seh-students:latest <your-dockerhub-username>/seh-students:latest
docker push <your-dockerhub-username>/seh-students:latest
```
### Pull and Run Docker Image
```bash
docker pull <your-dockerhub-username>/seh-students:latest
docker run -p 3000:3000 seh-students:latest
```
## API Usage

Use Postman or any API client to interact with the APIs.

## Get all students:

```
GET http://<host-ip>:3000/api/v1/student
```

Example Postman Request JSON Collection:
```bash
{
  "info": {
    "name": "SEH Students API",
    "_postman_id": "1234-5678-abcd-efgh",
    "description": "Collection for SEH Students APIs",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Get All Students",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:3000/api/v1/student",
          "protocol": "http",
          "host": ["localhost"],
          "port": "3000",
          "path": ["api", "v1", "student"]
        }
      },
      "response": []
    }
  ]
}
```
### Notes: Ensure Docker is installed on your machine before building or running images.