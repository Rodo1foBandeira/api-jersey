package com.APIGet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.model")
@EnableJpaRepositories(basePackages = "com.repo")
public class ApiGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetApplication.class, args);
	}

}
