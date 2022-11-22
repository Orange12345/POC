package com.changepond.executors.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.changepond.executors"})
@EntityScan(basePackages={"com.changepond.executors.db.model"})
public class SpringBootExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExecutorApplication.class, args);
	}

}
