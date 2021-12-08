package com.jpop8.bookservice.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swaggerBookApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .groupName("book-api-1.0")
		        .select()
		            .apis(RequestHandlerSelectors.basePackage("com.jpop8.bookservice.resources"))
		            .paths(regex("/books/v1.0.*"))
		        .build()
		        .apiInfo(new ApiInfoBuilder().version("1.0").title("Book API").description("Documentation Book API v1.0").build());
	}
}
