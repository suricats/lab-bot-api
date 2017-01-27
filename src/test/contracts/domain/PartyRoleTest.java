package test.contracts.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import contracts.domain.PartyRole;
import contracts.domain.Person;
import contracts.utils.FakeDataGenerator;

public class PartyRoleTest {
	
	@Test
	public void partyRoleConstructorTest(){
		String id = "id";
		String date = "06-06";
		String image = "http://www.suricats-consulting.com/wp-content/uploads/2016/05/A1-01-150x150.png";
		Person p = FakeDataGenerator.pers;
		String type = "type";
		
		PartyRole pr = new PartyRole(id, date, image, p, type);
		assertEquals(pr.getIdentifiant(), id);
		assertEquals(pr.getEnd_date(), date);
		assertEquals(pr.getImage(), image);
		assertEquals(pr.getPerson(), p);
		assertEquals(pr.getType(), type);
	}
	
	public void partyRoleSettersTest(){
		String id = "id";
		String date = "06-06";
		Person p = FakeDataGenerator.pers;
		String type = "type";
		
		PartyRole pr = new PartyRole("idBefore");
		pr.setEnd_date(date);
		pr.setIdentifiant(id);
		pr.setPerson(p);
		pr.setType(type);
		
		assertEquals(pr.getIdentifiant(), id);
		assertEquals(pr.getEnd_date(), date);
		assertEquals(pr.getPerson(), p);
		assertEquals(pr.getType(), type);
	}

	
}
