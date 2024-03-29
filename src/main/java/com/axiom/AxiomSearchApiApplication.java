package com.axiom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableFeignClients
@SpringBootApplication
@EnableSpringDataWebSupport
public class AxiomSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxiomSearchApiApplication.class, args);
	}

}
