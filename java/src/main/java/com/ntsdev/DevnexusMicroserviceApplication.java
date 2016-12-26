package com.ntsdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ntsdev")
public class DevNexusMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DevNexusMicroserviceApplication.class, args);
	}
}
