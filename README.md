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

### Step 2: Set up environment variables

Create a `.env` file in the root directory of the project with the following structure based on the `.env.example`:

```plaintext
# .env file
POSTGRES_DB=your_db_name
POSTGRES_USER=your_db_user
POSTGRES_PASSWORD=your_db_password
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/your_db_name
```

### Step 3: Build the application

Use Gradle to build the application:

```sh
./gradlew build
```

### Step 4: Build and run Docker containers

Build and start the Docker containers using Docker Compose:

```sh
docker-compose up --build
```
