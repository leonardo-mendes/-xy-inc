package com.challengePoint.configurations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.challengePoint.services.DatabaseService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DatabaseService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy; 
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
}