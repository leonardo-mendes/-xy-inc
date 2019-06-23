package com.challengePoint.services.implementations;

import com.challengePoint.mappers.PointOfInterestMapper;
import com.challengePoint.repositories.PointOfInterestRepository;
import com.challengePoint.resources.request.PointOfInterestRequest;
import com.challengePoint.resources.response.PointOfInterestResponse;
import com.challengePoint.services.PointOfInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointOfInterestImpl implements PointOfInterestService {

    @Autowired
    private PointOfInterestRepository pointRepository;

    @Autowired
    private PointOfInterestMapper pointOfInterestMapper;

    public List<PointOfInterestResponse> findAll() {
        return pointRepository.findAll().stream()
                .map(pointOfInterest -> pointOfInterestMapper.pointOfInterestToPointOfInterestResponse(pointOfInterest)).collect(Collectors.toList());

    }

    public PointOfInterestResponse insert(PointOfInterestRequest point) {
        return pointOfInterestMapper.pointOfInterestToPointOfInterestResponse(
                pointRepository.save(
                        pointOfInterestMapper.pointOfInterestRequestToPointOfInterest(point)
                )
        );
    }

    public List<PointOfInterestResponse> findByCoordenates(Integer x, Integer y, Integer distance) {
        return pointRepository.findAll().stream().filter(p -> p.getDistance(x, y) < distance)
                .map(pointOfInterest -> pointOfInterestMapper.pointOfInterestToPointOfInterestResponse(pointOfInterest)).collect(Collectors.toList());
    }

}
