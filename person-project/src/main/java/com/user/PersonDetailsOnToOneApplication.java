package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class PersonDetailsOnToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonDetailsOnToOneApplication.class, args);
	}

}
