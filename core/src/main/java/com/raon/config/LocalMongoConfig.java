package com.raon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import com.mongodb.ConnectionString;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Slf4j
@Configuration
public class LocalMongoConfig {
	private static final String MONGODB_IMAGE_NAME = "mongo:5.0";
	private static final Integer MONGODB_INNER_PORT = 27017;
	private static final String DATABASE_NAME = "notification";
	private static final GenericContainer mongo = createMongoInstance();

	private static GenericContainer createMongoInstance() {
		return new GenericContainer(DockerImageName.parse(MONGODB_IMAGE_NAME))
			.withExposedPorts(MONGODB_INNER_PORT)
			.withReuse(true);
	}

	@PostConstruct
	public void startMongo() {
		try {
			mongo.start();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@PreDestroy
	public void stopMongo() {
		try {
			mongo.stop();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Bean
	public MongoDatabaseFactory notificationMongoFactory() {
		return new SimpleMongoClientDatabaseFactory(connectionString());
	}

	private ConnectionString connectionString() {
		return new ConnectionString(
			"mongodb://" + mongo.getHost() + ":" + mongo.getMappedPort(MONGODB_INNER_PORT) + "/" + DATABASE_NAME);
	}
}
