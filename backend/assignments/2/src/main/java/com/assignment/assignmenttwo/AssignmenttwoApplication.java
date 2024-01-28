package com.assignment.assignmenttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AssignmenttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmenttwoApplication.class, args);
	}
}
