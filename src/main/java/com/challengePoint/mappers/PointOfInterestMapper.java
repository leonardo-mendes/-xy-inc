package com.challengePoint.mappers;

import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.resources.request.PointOfInterestRequest;
import com.challengePoint.resources.response.PointOfInterestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointOfInterestMapper {

    PointOfInterestResponse pointOfInterestToPointOfInterestResponse(PointOfInterest pointOfInterest);

    PointOfInterest pointOfInterestRequestToPointOfInterest(PointOfInterestRequest pointOfInterestRequest);

}
