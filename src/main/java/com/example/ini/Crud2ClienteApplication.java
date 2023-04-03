package com.example.ini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Crud2ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Crud2ClienteApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {

		return new RestTemplate();
	}
}
