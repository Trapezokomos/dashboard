# Dashboard API

## Overview

This project is a Spring Boot application that uses PostgreSQL as the database. The application is containerized using Docker Compose, and it includes monitoring with Prometheus and Grafana.

## Technologies Used

- **Spring Boot:** A Java-based framework used for building standalone and production-ready Spring applications.
- **PostgreSQL:** An open-source relational database system.
- **Docker:** A platform for developing, shipping, and running applications in containers.
  - **Docker Compose:** A tool for defining and running multi-container Docker applications.
  - **Dockerfile:** A script containing instructions on how to build a Docker image.
- **Prometheus:** An open-source systems monitoring and alerting toolkit.
- **Grafana:** An open-source platform for monitoring and observability, used to visualize data from Prometheus.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher
- Gradle
- Docker and Docker Compose

## Installation

### Step 1: Clone the repository

```sh
git clone https://github.com/Trapezokomos/dashboard.git
cd dashboard
```

### Step 2: Set up environment variables on configuration of IntelliJ IDEA

Create or edit the configuration
1. Click modify options and select environment variables
2. Add the following environment variables:

```plaintext
POSTGRES_DB_USER=postgres_username
POSTGRES_DB_PASSWORD=postgres_password
POSTGRES_DB_NAME=postgres
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
```

### Step 3: Build the application

Use Gradle to build the application:

```sh
./gradlew build
```

### Step 4: Build and run Docker containers

Build and start the Docker containers using Docker Compose:

```sh
docker build -t dashboard-app-image .
docker-compose up --build
```
## Development

### Swagger
You can access Swagger to test the endpoints
```sh
http://localhost:8080/swagger-ui/index.html
```

### Prometheus
You can access Prometheus to monitor the app (Username/Password= admin/admin) 
```sh
http://localhost:9090
````

### Grafana
You can access Grafana
```sh
http://localhost:3000
````
