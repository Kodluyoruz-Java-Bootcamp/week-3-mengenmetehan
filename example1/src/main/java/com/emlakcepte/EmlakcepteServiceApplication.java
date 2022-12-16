package com.emlakcepte;

import com.emlakcepte.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmlakcepteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakcepteServiceApplication.class, args);
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}
	

}
