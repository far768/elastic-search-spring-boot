package com.example.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class SpringbootelasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootelasticsearchApplication.class, args);
	}

}
