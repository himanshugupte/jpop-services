package com.jpop8.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
/* @RestController */
public class UserServiceApplication {

	/** For Config server example -- will re-use later */
	/*
	 * @Value("${bookservice.provider.url}") private String url;
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 */

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	/** For Config server example -- will re-use later */
	/*
	 * @GetMapping("/getBooks") public void getBooks() { List forObject =
	 * restTemplate.getForObject(url, List.class); System.out.println(forObject); }
	 * 
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

}
