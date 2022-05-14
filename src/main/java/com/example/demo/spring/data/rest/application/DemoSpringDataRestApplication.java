package com.example.demo.spring.data.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
		basePackages = {
				"com.example.demo.spring.data.rest.config", "com.example.demo.spring.data.rest.student.controller"
		}
)
public class DemoSpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataRestApplication.class, args);
	}

}
