package com.project.med.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.project.med.server.config.CustomAuthenticationProvider;
import com.project.med.service.UserService;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.project" })
public class Application {

	@Autowired
	CustomAuthenticationProvider authProvider;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserService userservice) throws Exception {
		builder.authenticationProvider(authProvider);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
