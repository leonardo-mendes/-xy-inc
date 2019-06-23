package com.challengePoint.resources.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointOfInterestRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty
	String name;

	@NotNull
	Integer x;

	@NotNull
	Integer y;
}