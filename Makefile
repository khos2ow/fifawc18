.PHONY: clean test build run

pom_version = $$(./mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -v '\[' | grep -v '\/' | grep -v 'Warning' | tr "[:upper:]" "[:lower:]" | tr -d "\r")

clean:
	./mvnw clean

test:
	./mvnw verify

build: clean
	./mvnw verify --activate-profiles production \
					-DskipTests=true \
					-Ddocker.image.version="$(pom_version)"

build-push: clean
	./mvnw verify --activate-profiles production \
					-DskipTests=true \
					-DpushImage \
					-DpushTags \
					-Ddocker.image.version="$(pom_version)" \
					--settings settings.xml

run:
	./mvnw spring-boot:run --activate-profiles development
