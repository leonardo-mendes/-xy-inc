package com.challengePoint.features;


import com.challengePoint.domains.PointOfInterest;
import com.challengePoint.repositories.PointOfInterestRepository;
import com.challengePoint.resources.request.PointOfInterestRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@ActiveProfiles({"test"})
public class PointOfInterestFeaturesTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PointOfInterestRepository pointRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

        Assert.assertNotNull(this.mappingJackson2HttpMessageConverter);
    }

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
    public void shouldFindAllPointsTest() throws Exception {
        mockMvc.perform(get("/points")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldFindPointByCoordenatesTest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("x", "20");
        params.add("y", "10");
        params.add("distance", "10");
        mockMvc.perform(get("/points/findByCoordenates").params(params)).andExpect(status().isOk())
                .andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldntFindPointByCoordenatesWithoutXTest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("y", "10");
        params.add("distance", "10");
        mockMvc.perform(get("/points/findByCoordenates").params(params)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntFindPointByCoordenatesWithoutYTest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("x", "20");
        params.add("distance", "10");
        mockMvc.perform(get("/points/findByCoordenates").params(params)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntFindPointByCoordenatesWithoutDistanceTest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("x", "20");
        params.add("y", "10");
        mockMvc.perform(get("/points/findByCoordenates").params(params)).andExpect(status().isBadRequest());
    }


    @Test
    public void shouldInsertPointTest() throws Exception {
        String poiJson = json(
                PointOfInterestRequest.builder()
                        .name("Test Insert Poi")
                        .y(30)
                        .x(30)
                        .build()
        );
        this.mockMvc.perform(post("/points").contentType(contentType).content(poiJson)).andExpect(status().isCreated());
    }

    private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
