package com.challengePoint.resources.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointOfInterestResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String name;
	Integer x;
	Integer y;
}