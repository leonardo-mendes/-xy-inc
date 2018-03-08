package com.challengePoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challengePoint.domains.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Integer>{ 

	
}
