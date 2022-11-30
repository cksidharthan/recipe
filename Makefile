run:
	mvn spring-boot:run

test:
	mvn test

lint:
	mvn checkstyle:check -Dcheckstyle.config.location=google_checks.xml -Dcheckstyle.consoleOutput=true