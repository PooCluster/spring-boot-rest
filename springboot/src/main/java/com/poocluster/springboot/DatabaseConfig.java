package com.poocluster.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // part of Spring Boot's list of beans for application context
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean  // will run once application context is loaded, HelloWorldRepository injected
    CommandLineRunner initDatabase(HelloWorldRepository helloWorldRepository) {
        return args -> {
          log.info("Prelaoding " + helloWorldRepository.save(new HelloWorld("Hello, World!")));
          log.info("Preloading " + helloWorldRepository.save(new HelloWorld("Goodbye, World!")));
        };
    }
}
