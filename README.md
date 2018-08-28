# Project description
Current system is meant to provide to users an opportunity for ordering vacation tours.
Visitors can register, list and buy tours. System has a Manager role for handling systems entities. 

# Project layers
+ Domain Model (domain entities)
+ Data Access Layer (data access objects)
+ Service Layer (services)
+ UI Layer (controllers, views)

# Acting roles
+ Tour Manager (admin)
+ Customer
+ Visitor

# Entity
+ Users
+ Tours
+ Orders

# Technological Stack
+ Language - Java 8
+ DB - PostgreSQL
+ Test framework - JUnit 5
+ Build tool - Maven
+ Code coverage tool - Jacoco
+ Annotation processor & code generatation - Lombok
+ CI tool - Jenkins
+ Deployment - Docker
+ Version control - Git/Gitlab

# DB Schema
![alt text](docs/DB Schema.png)
# Use Case diagram
![alt text](docs/UML.jpg)

# Access Matrix
![alt text](docs/access_matrix.png)

# Local Deployment Instruction
1. Checkout project into Idea from https://Roman_Samotoshenkov@git.epam.com/Mikhail_Sosnin/180813-studentproject.git
2. Open directory /docker in terminal
3. Build docker image and run the container
    ```
    docker build . -t app
    docker run -d --name application -p 8081:8080 app
    ```
4. Access app at url https://localhost:8081/app