package com.diceprojects.configurationsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EntityScan("com.diceprojects.configurationsservice.persistences.models.entities")
@EnableReactiveMongoRepositories(basePackages = "com.diceprojects.configurationsservice.persistences.repositories")
@EnableCaching
public class ConfigurationsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationsServiceApplication.class, args);
    }

}
