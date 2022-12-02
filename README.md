[![Code check](https://github.com/cksidharthan/recipe/actions/workflows/test.yml/badge.svg)](https://github.com/cksidharthan/recipe/actions/workflows/test.yml)
[![Code check](https://github.com/cksidharthan/recipe/actions/workflows/lint.yml/badge.svg)](https://github.com/cksidharthan/recipe/actions/workflows/lint.yml)


# Recipe Rest API
Rest API for Recipe App using Java Spring Boot and H2 Database

## Pre-requisites
- Java 11
- Maven 3.6.3
- Git
- Lombok Plugin

## Running the application locally
- Clone the repository
- Run `mvn clean install`
- Run `mvn spring-boot:run`

## Running the tests
- Run `mvn clean test`

## Running Lint
- Run `mvn checkstyle:check -Dcheckstyle.config.location=google_checks.xml -Dcheckstyle.consoleOutput=true`

## Running the tests with coverage
- Run `mvn clean test jacoco:report`
- Report can be found in `target/site/jacoco/index.html`

## Swagger UI
- Application is integrated with swagger
- Swagger UI can be viewed on `http://localhost:8082/swagger-ui.html`

## Makefile
- Makefile is added to run the commands
- Run `make help` to see the list of commands
- Run `make run` to run the application
- Run `make test` to run the tests
- Run `make lint` to run the lint
- Run `make coverage` to run the tests with coverage
- Run `make clean` to clean the project
- Run `make build` to build the project
