package com.caftingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CraftingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CraftingoApplication.class, args);
	}

}
