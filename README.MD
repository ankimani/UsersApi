# Project Description
This is A JAVA REST API WITH SPRINGBOOT using JPA,HIBERNATE,MySQL

## How To Set Up in Your Machine
1. Clone the application

https://github.com/ankimani/UsersApi.git

2. Create Mysql database

create database UserDb

3. Change mysql username and password based on your preferences

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn package
java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at http://localhost:8080.

I created a folder in my documents main folder.the folder name is switchcase.
i then initilised the repository using git init after which i created the project files

### The API endpoints
Explore Rest APIs

The app defines following CRUD APIs Endpoints

GET /api/v1/users

POST /api/v1/users

GET /api/v1/users/{userId}

PUT /api/v1/users/{userId}

DELETE /api/v1/users/{userId}

