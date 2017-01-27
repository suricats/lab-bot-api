package test.contracts.controllers;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import contracts.controllers.PersonController;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }
    
    @Test
    public void getListPersonsTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/persons")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
		JSONArray jsonPersonChoice = new JSONArray(result.getResponse().getContentAsString());
		assertEquals(jsonPersonChoice.length(),3);
		assertEquals(jsonPersonChoice.getJSONObject(0).getString("href"), "http://localhost/insurance/persons/PE5631851");
		assertEquals(jsonPersonChoice.getJSONObject(1).getString("href"), "http://localhost/insurance/persons/PE1781566");
		assertEquals(jsonPersonChoice.getJSONObject(2).getString("href"), "http://localhost/insurance/persons/PE0684000");
    }
    
    
    @Test
    public void getPersonTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/persons/PE1781566")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
		JSONObject jsonPerson = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(jsonPerson.toString().contains("birth_date"));
		assertTrue(jsonPerson.toString().contains("client_number"));
		assertTrue(jsonPerson.toString().contains("first_name"));
		assertTrue(jsonPerson.toString().contains("last_name"));
		assertTrue(jsonPerson.toString().contains("postal_code"));
		assertEquals(5, jsonPerson.keySet().size()); 
    }

}
