package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Component
@EnableSwagger2
public class PersonDetailsOnToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonDetailsOnToOneApplication.class, args);
	}

}
