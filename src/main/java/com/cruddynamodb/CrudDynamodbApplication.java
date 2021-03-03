package com.cruddynamodb;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.cruddynamodb.repository")
public class CrudDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDynamodbApplication.class, args);
	}

}
