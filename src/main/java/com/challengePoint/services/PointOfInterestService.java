package com.challengePoint.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengePoint.contracts.PointOfInterestContract;
import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.repositories.PointOfInterestRepository;
import com.challengePoint.services.exceptions.ParametersException;

@Service
public class PointOfInterestService implements PointOfInterestContract{
	
	@Autowired 
	private PointOfInterestRepository pointRepository; 
	
	public List<PointOfInterest> findAll() {
		return pointRepository.findAll();
	}
		
	public PointOfInterest insert(PointOfInterest point) {
		point.setId(null); 
		if(point.getName() == null || point.getX() == null || point.getY() == null) {
			throw new ParametersException("Could not create a Point of Interest, name, coordinate x and coordinate y are mandatory.");
		}
		
		return pointRepository.save(point); 
	}
	
	
	public List<PointOfInterest> findByCoordenates(Integer x, Integer y, Integer distance){
		List<PointOfInterest> allPoints = this.findAll();
		
		Stream<PointOfInterest> filterDistance = allPoints.stream().filter(p -> p.getDistance(x, y) < distance);

		return filterDistance.collect(Collectors.toList());
	}

}
