package com.crud.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
class CrudSpringBootOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootOperationApplication.class, args);
	}

}
