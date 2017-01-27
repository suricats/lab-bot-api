package test.contracts.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import contracts.domain.Couverture;
import contracts.domain.Risk;
import contracts.utils.FakeDataGenerator;

public class RiskTest {
	
	@Test
	public void riskConstructorTest(){
		String id = "id";
		String name = "name", label = "label";
		int montant = 20, bonusMalus = 50;
		String end = "06-06";
		Couverture couv = FakeDataGenerator.getFakeCouvertureAllTrue();
		
		Risk r = new Risk(id, name, montant, bonusMalus, label, end, couv);
		assertEquals(r.getIdentifiant(), id);
		assertEquals(r.getName(), name);
		assertEquals(r.getMontant(), montant);
		assertEquals(r.getBonusMalus(), bonusMalus);
		assertEquals(r.getLabel(), label);
		assertEquals(r.getEnd_date(), end);
		assertEquals(r.getCouverture(), couv);
	}
	
	public void riskSettersTest(){
		String id = "id";
		String name = "name", label = "label";
		int montant = 20, bonusMalus = 50;
		String end = "06-06";
		Couverture couv = FakeDataGenerator.getFakeCouvertureAllTrue();
		
		Risk r = FakeDataGenerator.getFakeRisk();
		r.setIdentifiant(id);
		r.setName(name);
		r.setMontant(montant);
		r.setBonusMalus(bonusMalus);
		r.setLabel(label);
		r.setEnd_date(end);
		r.setCouverture(couv);
		
		assertEquals(r.getIdentifiant(), id);
		assertEquals(r.getName(), name);
		assertEquals(r.getMontant(), montant);
		assertEquals(r.getBonusMalus(), bonusMalus);
		assertEquals(r.getLabel(), label);
		assertEquals(r.getEnd_date(), end);
		assertEquals(r.getCouverture(), couv);
	}

}
