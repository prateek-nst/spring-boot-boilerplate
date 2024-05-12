package com.discovery.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableFeignClients
@SpringBootApplication
public class MsOneApplication {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(MsOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("@@@@@@@@@@@");
			System.out.println(environment.getProperty("build.version"));
			System.out.println(environment.getProperty("accounts.message"));
		};
	}
}
