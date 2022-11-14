package com.project.fines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FinesApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinesApplication.class, args);
	}
}
