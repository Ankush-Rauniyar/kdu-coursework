package com.handsontwelve.twelvehomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan
//@EnableJpaRepositories("com.handsontwelve.twelvehomework.dao.*")
//@EntityScan("com.handsontwelve.twelvehomework.entity.*")
public class TwelvehomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwelvehomeworkApplication.class, args);
	}

}
