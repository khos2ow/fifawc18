STATIC_DIR=./src/main/resources/static

# CSS params
CSS_DIR = assets/css
CSS_SRC_FILE = app.css
CSS_MIN_FILE = app.min.css

# JS params
JS_DIR = assets/js
JS_SRC_FILE = app.js
JS_MIN_FILE = app.min.js

.PHONY: clean test build build-css build-js build-push run

pom_version = $$(./mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -v '\[' | grep -v '\/' | grep -v 'Warning' | tr "[:upper:]" "[:lower:]" | tr -d "\r")

clean:
	./mvnw clean

test:
	./mvnw verify

build: clean build-css build-js
	./mvnw verify --activate-profiles production \
					-DskipTests=true \
					-Ddocker.image.version="$(pom_version)"

build-css:
	uglifycss $(STATIC_DIR)/$(CSS_DIR)/$(CSS_SRC_FILE) > $(STATIC_DIR)/$(CSS_DIR)/$(CSS_MIN_FILE)

build-js:
	uglifyjs $(STATIC_DIR)/$(JS_DIR)/$(JS_SRC_FILE) > $(STATIC_DIR)/$(JS_DIR)/$(JS_MIN_FILE)

build-push: clean
	./mvnw verify --activate-profiles production \
					-DskipTests=true \
					-DpushImage \
					-DpushTags \
					-Ddocker.image.version="$(pom_version)" \
					--settings settings.xml

run:
	./mvnw spring-boot:run --activate-profiles development
