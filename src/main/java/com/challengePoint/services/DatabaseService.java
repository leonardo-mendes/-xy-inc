package com.challengePoint.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.repositories.PointOfInterestRepository;

@Service
public class DatabaseService {

	@Autowired
	private PointOfInterestRepository poirepository;
	
	public void instantiateTestDatabase() throws ParseException {

		PointOfInterest lanchonete = new PointOfInterest(null, "Lanchonete", 27, 12);
		PointOfInterest posto = new PointOfInterest(null, "Posto", 31, 18);
		PointOfInterest joalheria = new PointOfInterest(null, "Joalheria", 15, 18);
		PointOfInterest floricultura = new PointOfInterest(null, "Floricultura", 19, 21);
		PointOfInterest pub = new PointOfInterest(null, "Pub", 12, 8);
		PointOfInterest supermecado = new PointOfInterest(null, "Supermercado", 23, 6);
		PointOfInterest churrascaria = new PointOfInterest(null, "Churrascaria", 28, 2);
		
		poirepository.save(Arrays.asList(lanchonete,posto,joalheria,floricultura,pub,supermecado,churrascaria));
	}

}
