package com.horn.edu.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.horn.edu.sso.server.dao")
public class HornEduSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HornEduSsoApplication.class, args);
	}
}
