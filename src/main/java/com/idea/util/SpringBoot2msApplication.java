package com.idea.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.idea.dao","com.idea.service","com.idea.datasource","com.idea.controller"})
public class SpringBoot2msApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2msApplication.class, args);
	}

}
