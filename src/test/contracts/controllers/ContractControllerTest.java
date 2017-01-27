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

import contracts.controllers.ContractController;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContractControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(new ContractController()).build();
    }

    @Test
    public void getCouvertureChoiceTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-45454/risk/")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
		JSONArray jsonCouvertureChoice = new JSONArray(result.getResponse().getContentAsString());
		assertEquals(jsonCouvertureChoice.length(),3);
		assertEquals(jsonCouvertureChoice.getJSONObject(0).getString("href"), "http://localhost/insurance/contract/ID-45454/risk/ID-02453620/couverture");
		assertEquals(jsonCouvertureChoice.getJSONObject(1).getString("href"), "http://localhost/insurance/contract/ID-45454/risk/ID-8944710/couverture");
		assertEquals(jsonCouvertureChoice.getJSONObject(2).getString("href"), "http://localhost/insurance/contract/ID-45454/risk/ID-52665236/couverture");
    }
    
    @Test
    public void getCouvertureInfoTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-45454/risk/ID-02453620/couverture")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
    	JSONObject jsonCouverture = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(jsonCouverture.toString().contains("incendie"));
		assertTrue(jsonCouverture.toString().contains("inondation"));
		assertTrue(jsonCouverture.toString().contains("vandalisme"));
		assertEquals(3, jsonCouverture.keySet().size());
    }
    
    @Test
    public void getBillingChoiceTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-891135/billings/")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
		JSONArray jsonBillingChoice = new JSONArray(result.getResponse().getContentAsString());
		assertEquals(jsonBillingChoice.length(),3);
		assertEquals(jsonBillingChoice.getJSONObject(0).getString("href"), "http://localhost/insurance/contract/ID-891135/billings/ID-96268885");
		assertEquals(jsonBillingChoice.getJSONObject(1).getString("href"), "http://localhost/insurance/contract/ID-891135/billings/ID-2355596664");
		assertEquals(jsonBillingChoice.getJSONObject(2).getString("href"), "http://localhost/insurance/contract/ID-891135/billings/ID-123987456");
    }
    
    @Test
    public void getBillingInfoTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-891135/billings/ID-123987456")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
    	JSONObject jsonBilling = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(jsonBilling.toString().contains("identifiant"));
		assertTrue(jsonBilling.toString().contains("amount"));
		assertTrue(jsonBilling.toString().contains("frequency"));
		assertTrue(jsonBilling.toString().contains("next_date"));
		assertTrue(jsonBilling.toString().contains("methode"));
		assertEquals(5, jsonBilling.keySet().size()); 
	}

    public void getPartyRoleChoiceTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-875335/partyRoles/")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
		JSONArray jsonPartyRoleChoice = new JSONArray(result.getResponse().getContentAsString());
		assertEquals(jsonPartyRoleChoice.length(),2);
		assertEquals(jsonPartyRoleChoice.getJSONObject(0).getString("href"), "http://localhost/insurance/contract/ID-875335/partyRoles/ID-78595");
		assertEquals(jsonPartyRoleChoice.getJSONObject(1).getString("href"), "http://localhost/insurance/contract/ID-875335/partyRoles/ID-787634");
    }
    
    @Test
    public void getPartyRoleInfoTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-875335/partyRoles/ID-78595")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
    	JSONObject jsonPartyRole = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(jsonPartyRole.toString().contains("identifiant"));
		assertTrue(jsonPartyRole.toString().contains("end_date"));
		assertTrue(jsonPartyRole.toString().contains("image"));
		assertTrue(jsonPartyRole.toString().contains("type"));
		assertTrue(jsonPartyRole.toString().contains("person"));
		assertEquals(5, jsonPartyRole.keySet().size()); 
		JSONObject jsonPerson = jsonPartyRole.getJSONObject("person");
		assertTrue(jsonPerson.toString().contains("birth_date"));
		assertTrue(jsonPerson.toString().contains("client_number"));
		assertTrue(jsonPerson.toString().contains("first_name"));
		assertTrue(jsonPerson.toString().contains("last_name"));
		assertTrue(jsonPerson.toString().contains("postal_code"));
		assertEquals(5, jsonPerson.keySet().size()); 
	}
   
    @Test
    public void getRibTest() throws Exception {
    	MvcResult result = mockMvc.perform(get("/insurance/contract/ID-875335/rib")
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andReturn();
		
    	JSONObject jsonRib = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(jsonRib.toString().contains("image"));
		assertEquals(jsonRib.getString("image"), "https://mabanque.bnpparibas/rsc/contrib/image/particuliers/gabarits-libres/rib.jpg");
		assertEquals(1, jsonRib.keySet().size()); 
	}

}