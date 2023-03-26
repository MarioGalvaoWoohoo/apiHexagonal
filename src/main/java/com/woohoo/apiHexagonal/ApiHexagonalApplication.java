package com.woohoo.apiHexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHexagonalApplication.class, args);
	}

}
