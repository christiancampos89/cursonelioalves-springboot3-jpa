package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User usuario1 = new User(null, "Christian Rafael e Campos", "christian@pti.com.br", "45999886639", "12345");
		User usuario2 = new User(null, "Elisangela Campos", "elisagenla@gmail.com", "45999989295", "12345");
		
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
		
	}
}
