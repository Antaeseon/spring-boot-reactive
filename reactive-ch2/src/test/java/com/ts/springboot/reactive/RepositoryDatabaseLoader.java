package com.ts.springboot.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // <1>
public class RepositoryDatabaseLoader {

	@Bean
		// <2>
	CommandLineRunner initialize(BlockingItemRepository repository) { // <3>
		return args -> { // <4>
			repository.save(new Item("Alf alarm clock", 19.99));
			repository.save(new Item("Smurf TV tray", 24.99));
		};
	}
}
