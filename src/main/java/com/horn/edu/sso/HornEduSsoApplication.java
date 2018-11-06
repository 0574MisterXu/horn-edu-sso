package com.horn.edu.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HornEduSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HornEduSsoApplication.class, args);
	}
}
