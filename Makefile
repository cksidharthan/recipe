.PHONY: help
help:
	@awk 'BEGIN {FS = ":.*##"; printf "Usage: make \033[36m<target>\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-10s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

run: ## Run the application
	mvn spring-boot:run

test: ## Run the tests
	mvn test

lint: ## Run the linter
	mvn checkstyle:check -Dcheckstyle.config.location=google_checks.xml -Dcheckstyle.consoleOutput=true

# make jacoco report and open it in browser
report: ## Generate the coverage report
	mvn test jacoco:report && open target/site/jacoco/index.html

clean: ## Clean the project
	mvn clean

build: clean ## Build the project
	mvn package
