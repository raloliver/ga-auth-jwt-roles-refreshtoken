package com.raloliver.authservice;

import java.util.ArrayList;

import com.raloliver.authservice.domain.Role;
import com.raloliver.authservice.domain.User;
import com.raloliver.authservice.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_USER"));

			userService.saveUser(new User(null, "Israel Oliveira", "israel", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Ral", "ral", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Oliver", "oliver", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Ral Oliver", "raloliver", "password", new ArrayList<>()));

			userService.addUserRole("ral", "ROLE_USER");
			userService.addUserRole("israel", "ROLE_USER");
			userService.addUserRole("israel", "ROLE_MANAGER");
			userService.addUserRole("oliver", "ROLE_ADMIN");
			userService.addUserRole("raloliver", "ROLE_USER");
			userService.addUserRole("raloliver", "ROLE_ADMIN");
			userService.addUserRole("raloliver", "ROLE_SUPER_USER");
		};
	}

}
