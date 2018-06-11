package io.khosrow.fifawc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.khosrow.fifawc.common.config.AppConfig;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class Fifawc18Application {
    public static void main(String[] args) {
        SpringApplication.run(Fifawc18Application.class, args);
    }
}
