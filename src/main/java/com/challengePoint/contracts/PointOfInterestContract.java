package com.challengePoint.contracts;

import java.util.List;

import com.challengePoint.domains.PointOfInterest;

public interface PointOfInterestContract {

	public List<PointOfInterest> findAll();
	
	public PointOfInterest insert(PointOfInterest point);
	
	public List<PointOfInterest> findByCoordenates(Integer x, Integer y, Integer distance);
	
}
