package com.challengePoint.domains;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointOfInterest implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String name;
	Integer x;
	Integer y;
	
	public Double getDistance(Integer xParameter, Integer yParameter) {
		return Math.sqrt(Math.pow((this.x - xParameter), 2) + Math.pow((this.y - yParameter), 2));
	}
	
}