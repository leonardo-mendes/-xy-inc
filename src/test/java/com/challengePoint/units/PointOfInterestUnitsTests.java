package com.challengePoint.units;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.challengePoint.contracts.PointOfInterestContract;
import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.repositories.PointOfInterestRepository;
import com.challengePoint.services.exceptions.ParametersException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class PointOfInterestUnitsTests {
	
	@Autowired
	private PointOfInterestContract pointService;
	
	@Autowired
	private PointOfInterestRepository pointRepository;

	@Before
	public void setUp() {

	}
	
	@Test
	public void testFindAll() {
		List<PointOfInterest> list = pointService.findAll();
		
		Assert.assertNotNull("failure - expected not null", list);
		Assert.assertEquals("failure - expected size", 7, list.size());
	}
	
    @Test
    public void testInsert() {

    	PointOfInterest entity = new PointOfInterest();
    	entity.setName("PointTest");
    	entity.setX(50);
    	entity.setY(20);

    	PointOfInterest point = pointService.insert(entity);

        Assert.assertNotNull("failure - expected not null", point);
        Assert.assertNotNull("failure - expected id attribute not null",point.getId());
        Assert.assertEquals("failure - expected name attribute match", "PointTest", point.getName());
        
        pointRepository.delete(point.getId());
    }
    
    @Test(expected = ParametersException.class)
    public void testInsertCoordinateXFailure() throws Exception{

    	PointOfInterest entity = new PointOfInterest();
    	entity.setName("PointTest");
    	entity.setY(50);

    	pointService.insert(entity);
    }
    
    @Test(expected = ParametersException.class)
    public void testInsertCoordinateYFailure() throws Exception{

    	PointOfInterest entity = new PointOfInterest();
    	entity.setName("PointTest");
    	entity.setX(50);

    	pointService.insert(entity);
    }
    
    @Test(expected = ParametersException.class)
    public void testInsertNameFailure() throws Exception{

    	PointOfInterest entity = new PointOfInterest();
    	entity.setY(10);
    	entity.setX(50);

    	pointService.insert(entity);
    }
    
    @Test
    public void testFindByCoordinates(){
		List<PointOfInterest> list = pointService.findByCoordenates(20, 10, 10);
		
		Assert.assertNotNull("failure - expected not null", list);
		Assert.assertEquals("failure - expected size", 4, list.size());
    }

}