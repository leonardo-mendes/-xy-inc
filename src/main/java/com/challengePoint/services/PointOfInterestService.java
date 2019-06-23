package com.challengePoint.services;

import com.challengePoint.resources.request.PointOfInterestRequest;
import com.challengePoint.resources.response.PointOfInterestResponse;

import java.util.List;

public interface PointOfInterestService {

    List<PointOfInterestResponse> findAll();

    PointOfInterestResponse insert(PointOfInterestRequest point);

    List<PointOfInterestResponse> findByCoordenates(Integer x, Integer y, Integer distance);

}
