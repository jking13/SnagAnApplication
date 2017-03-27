#SnagAnApplication
This application allows the user to create questions, and then create applications which are then validated against these questions. Applications are only stored if they answer all questions correctly.

##Running
###Requirements

- docker compose (https://docs.docker.com/compose/install/)

###Build Steps

- `docker-compose build` (to avoid docker caching between runs)
- `docker-compose up -d`
- confirm application is running at `http://localhost:4200`

##Tech Stack

- Docker compose for easy dev builds
- Elasticsearch data store for easy searching
- Spring Boot backend server (Swagger ui is also enabled for easy api documentation `http://localhost:8000/swagger-ui.html`)
- Angular 2