package com.challengePoint.units;


import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.mappers.PointOfInterestMapper;
import com.challengePoint.repositories.PointOfInterestRepository;
import com.challengePoint.resources.request.PointOfInterestRequest;
import com.challengePoint.resources.response.PointOfInterestResponse;
import com.challengePoint.services.PointOfInterestService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class PointOfInterestUnitsTests {
	
	@Autowired
	private PointOfInterestService pointService;
	
	@Autowired
	private PointOfInterestRepository pointRepository;

	@Before
	public void setUp() {
		pointRepository.save(
				PointOfInterest.builder()
				.name("PointTest")
				.x(20)
				.y(10)
				.build()
		);
	}

	@After
	public final void tearDown() {
		pointRepository.deleteAll();
	}

	@Test
	public void testFindAll() {
		List<PointOfInterestResponse> list = pointService.findAll();
		assertNotNull(list);
		assertEquals(1, list.size());
	}

    @Test
    public void testInsert() {
    	PointOfInterestResponse point = pointService.insert(
    			PointOfInterestRequest.builder()
						.name("PointTest2")
						.x(55)
						.y(25)
						.build()
		);
        assertNotNull(point);
        assertEquals("PointTest2", point.getName());
    }
    
    @Test
    public void testFindByCoordinates(){
		List<PointOfInterestResponse> list = pointService.findByCoordenates(20, 10, 10);
		assertNotNull(list);
		assertEquals(1, list.size());
    }
}
