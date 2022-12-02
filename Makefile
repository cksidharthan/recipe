run:
	mvn spring-boot:run

test:
	mvn test

lint:
	mvn checkstyle:check -Dcheckstyle.config.location=google_checks.xml -Dcheckstyle.consoleOutput=true

# make jacoco report
test-report:
	mvn test jacoco:report
