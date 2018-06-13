.PHONY: clean demo build

build: clean
	echo "TODO"

demo:
	./mvnw spring-boot:run --activate-profiles development

clean:
	./mvnw clean
