package com.khja021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ChatModuleApplication extends SpringBootServletInitializer{

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ChatModuleApplication.class);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(ChatModuleApplication.class, args);
	}
}

