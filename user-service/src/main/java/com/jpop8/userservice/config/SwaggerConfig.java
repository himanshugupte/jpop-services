package com.jpop8.userservice.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	public static final String USER_TAG = "user-service";
	
	@Bean
	public Docket swaggerUserApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .groupName("user-api-1.0")
		        .select()
		            .apis(RequestHandlerSelectors.basePackage("com.jpop8.userservice.resources"))
		            .paths(regex("/users/v1.0.*"))
		        .build()
		        .tags(new Tag(USER_TAG, "Operations pertaining to users in JPoP"))
		        .apiInfo(new ApiInfoBuilder().version("1.0").title("User API").description("Documentation User API v1.0").build());
	}
}	
