package com.challengePoint.configurations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.challengePoint.services.DatabaseService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DatabaseService dbService;

	@Bean
	public Boolean instantiateDataBase() throws ParseException {
		dbService.instantiateTestDatabase();		
		return true;
	}
	
}