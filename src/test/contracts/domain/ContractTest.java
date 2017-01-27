package test.contracts.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import contracts.domain.Billing;
import contracts.domain.Contract;
import contracts.domain.PartyRole;
import contracts.domain.Risk;
import contracts.utils.FakeDataGenerator;

public class ContractTest {

	@Test
	public void contractTestConstructor1(){
		String id = "id";
		
		Contract c = new Contract(id);
		
		assertEquals(c.getIdentifiant(), id);
		assertNull(c.getObjetsCouverts());
		assertNull(c.getBillings());
		assertNull(c.getPartyRoles());
	}
	
	@Test
	public void contractTestConstructor2(){
		String id = "id";
		List<Risk> risks = Arrays.asList(FakeDataGenerator.getFakeRisk());
		
		Contract c = new Contract(id, risks, null, null);
		
		assertEquals(c.getIdentifiant(), id);
		assertEquals(c.getObjetsCouverts(), risks);
		assertNull(c.getBillings());
		assertNull(c.getPartyRoles());
	}
	
	@Test
	public void contractTestConstructor3(){
		String id = "id";
		List<Risk> risks = Arrays.asList(FakeDataGenerator.getFakeRisk());
		List<Billing> billings = Arrays.asList(FakeDataGenerator.getFakeBilling());
		List<PartyRole> roles = Arrays.asList(FakeDataGenerator.getFakePartyRole());
		
		Contract c = new Contract(id, risks, billings, roles);
		
		assertEquals(c.getIdentifiant(), id);
		assertEquals(c.getObjetsCouverts(), risks);
		assertEquals(c.getBillings(), billings);
		assertEquals(c.getPartyRoles(), roles);
	}
	
	@Test
	public void contractAddTests(){
		List<Risk> risks = new ArrayList<>(Arrays.asList(FakeDataGenerator.getFakeRisk()));
		List<Billing> billings = new ArrayList<>(Arrays.asList(FakeDataGenerator.getFakeBilling()));
		List<PartyRole> roles = new ArrayList<>(Arrays.asList(FakeDataGenerator.getFakePartyRole()));
		
		Contract c = new Contract("id", risks, billings, roles);
		
		assertEquals(c.getObjetsCouverts().size(), risks.size());
		assertEquals(c.getBillings().size(), billings.size());
		assertEquals(c.getPartyRoles().size(), roles.size());
		
		c.addBilling(FakeDataGenerator.getFakeBilling());
		c.addObjetCouvert(FakeDataGenerator.getFakeRisk());
		c.addPartyRole(FakeDataGenerator.getFakePartyRole());
		
		assertEquals(c.getObjetsCouverts().size(), risks.size()+1);
		assertEquals(c.getBillings().size(), billings.size()+1);
		assertEquals(c.getPartyRoles().size(), roles.size()+1);
		
	}

}
