package com.ntsdev.config;


import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * Defines the service name for the MongoDB connection.  Searches Spring Cloud Connectors
 * for a suitable service named "devnexus" that can provide a MongoDBFactory.
 */
@Configuration
public class MongoDBConfig extends AbstractCloudConfig {
    @Bean
    public MongoDbFactory mongoFactory() {
        return connectionFactory().mongoDbFactory("devnexus");
    }
}
