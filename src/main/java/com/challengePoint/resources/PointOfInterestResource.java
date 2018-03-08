package com.challengePoint.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.services.PointOfInterestService;

@RestController
@RequestMapping(value="/points")
public class PointOfInterestResource {
	
	@Autowired
	private PointOfInterestService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PointOfInterest>> findAll() {
		List<PointOfInterest> listAll = service.findAll();

		return ResponseEntity.ok().body(listAll);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PointOfInterest point) {
		PointOfInterest pointResponse = service.insert(point);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
						.buildAndExpand(pointResponse.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/findByCoordenates", method = RequestMethod.GET)
	public ResponseEntity<List<PointOfInterest>> findByCoordenates(
			@RequestParam(value = "x") Integer x,
			@RequestParam(value = "y") Integer y,
			@RequestParam(value = "distance") Integer distance) {
		
		List<PointOfInterest> returnPoints = service.findByCoordenates(x, y, distance);
		
		return ResponseEntity.ok().body(returnPoints);
	}
	
}
