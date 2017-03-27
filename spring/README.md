# SnagAnApplication/Spring
Spring boot portion of SnagAnApplication.

## Running
### Requirements

- Java 8
- Elasticsearch 2.4
	- Server looks for elasticsearch on localhost:9300 by default
	- The fastest way to grab an elasticsearch docker container is to run `docker-compose up -d` on the root project.

### Testing

- `./gradlew test`

### Build Steps

- `./gradlew bootRun`
- confirm server is running by visiting the swagger documentation `http://localhost:8000/swagger-ui.html`