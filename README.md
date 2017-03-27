# SnagAnApplication
This application allows the user to create questions, and then create applications which are then validated against these questions. Applications are only stored if they answer all questions correctly.

## Running
### Requirements

- docker compose (https://docs.docker.com/compose/install/)

### Build Steps

- `docker-compose build`

### Deploying
- `docker-compose up -d`
- confirm backend spring server is running at either `http://localhost:8000/app_status` or `http://localhost:8000/swagger-ui.html`
	- it can take a couple minutes for the app to boot
- confirm frontend is running at `http://localhost:4200`

## Tech Stack

- Docker compose for easy dev builds
- Elasticsearch data store for easy searching
- Spring Boot backend server (Swagger ui is also enabled for easy api documentation `http://localhost:8000/swagger-ui.html`)
- Angular 2

## Searching
Searches are passed through to elasticsearch in a match all query. This means that elasticsearch takes each word in the query and then matches it to the entire document which has been put through the standard analyzer. In layman's terms this means that if any word in the query matches a word in the stored document (case insensitive) then the doc is returned. 