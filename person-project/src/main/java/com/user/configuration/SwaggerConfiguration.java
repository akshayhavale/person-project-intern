package com.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Component
public class SwaggerConfiguration {

	@Bean
	public Docket Configuration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.user	")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {

		return new ApiInfo("USER PROJECT", "User Deatails", "v1", "", "AKSHAY HAVALE", "", "");
	}

}
