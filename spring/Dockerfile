FROM java:8

COPY . /spring/

WORKDIR /spring/

RUN ./gradlew clean build

ENTRYPOINT ./gradlew bootRun