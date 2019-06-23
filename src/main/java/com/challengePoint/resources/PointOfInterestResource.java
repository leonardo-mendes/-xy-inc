package com.challengePoint.resources;

import com.challengePoint.resources.request.PointOfInterestRequest;
import com.challengePoint.resources.response.PointOfInterestResponse;
import com.challengePoint.services.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/points")
public class PointOfInterestResource {

    @Autowired
    private PointOfInterestService service;

    @GetMapping
    public ResponseEntity<List<PointOfInterestResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PointOfInterestRequest point) {
        service.insert(point);
    }

    @GetMapping(value = "/findByCoordenates")
    public ResponseEntity<List<PointOfInterestResponse>> findByCoordenates(
            @RequestParam(value = "x") Integer x,
            @RequestParam(value = "y") Integer y,
            @RequestParam(value = "distance") Integer distance) {
        return ResponseEntity.ok().body(service.findByCoordenates(x, y, distance));
    }

}
