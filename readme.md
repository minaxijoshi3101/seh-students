# SEH Students Spring Boot Application

![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)

A Spring Boot application for managing student information. The app exposes REST APIs to interact with student data.

---

## Git Repository

Clone the repository:

```bash
git clone https://github.com/minaxijoshi3101/seh-students.git
cd seh-students

Folder Structure
seh-students/
├── src/
│   ├── main/
│   │   ├── java/com/example/sehstudents/  # Java source code
│   │   └── resources/
│   │       └── application.properties     # Configuration
│   └── test/                              # Test classes
├── target/                                # Compiled JAR files
├── Dockerfile                             # Docker build file
└── pom.xml                                # Maven configuration

Build the Application

Use Maven to build:
mvn clean package
