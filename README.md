# bcb-sms-simulator
This is a simple application to simulate a sms sending tool for the BCB project.
You can test the bcb-core-app sending a message with this app up or down.

## Build and Run

### 1. Build Application

To build the application use the maven commands:

` mvn clean install `

### 2. Build docker image

You can build a docker image for this app only, or build all the stack with docker-compose following the steps in [BCB-INFRA](https://github.com/DevJamila/bcb-infra) repository.

Build the docker image with a tag name

` docker build -t bcb-sms-simulator `

### 3. Run with Docker

Also you can run all the stack with [docker-compose](https://github.com/DevJamila/bcb-infra/blob/main/docker-compose.yaml)
or run the app container exposing the 8081 port

` docker run -d --name bcb-sms-simulator -p 8081:8081 bcb-sms-simulator `

## Make a Request

Endpoint to simulate SMS sending, it checks wether the request body fields are not empty.

` POST /sms `

Access the request body json model on the Swagger UI.

` http://localhost:8081/swagger-ui/index.html `

## Test

Execute the automated tests with the maven command:

` mvn test `