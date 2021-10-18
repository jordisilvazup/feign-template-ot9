package com.example.feign.clientshttptemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientsHttpTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsHttpTemplateApplication.class, args);
	}

}
