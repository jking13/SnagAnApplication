FROM node:latest

RUN npm install -g @angular/cli

COPY . /angular
WORKDIR angular

RUN npm install

ENTRYPOINT ng serve --host 0.0.0.0 --environment=prod
