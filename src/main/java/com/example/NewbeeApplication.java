package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.example.newbee.dao")
public class NewbeeApplication extends SpringBootServletInitializer {
	//整合到github 000
	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(NewbeeApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(NewbeeApplication.class, args);
	}
}
