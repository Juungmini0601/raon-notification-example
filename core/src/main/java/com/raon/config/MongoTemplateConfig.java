package com.raon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Configuration
@EnableMongoRepositories(
	basePackages = "com.raon",
	mongoTemplateRef = MongoTemplateConfig.MONGO_TEMPLATE
)
public class MongoTemplateConfig {

	public static final String MONGO_TEMPLATE = "notificationMongoTemplate";

	@Bean(name = MONGO_TEMPLATE)
	public MongoTemplate notificationMongoTemplate(
		MongoDatabaseFactory notificationMongoFactory,
		MongoConverter mongoConverter
	) {
		return new MongoTemplate(notificationMongoFactory, mongoConverter);
	}
}
