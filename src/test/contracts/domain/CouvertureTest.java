package test.contracts.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import contracts.domain.Couverture;

public class CouvertureTest {
	
	@Test
	public void billingConstructorTest(){
		Couverture c = new Couverture(true, true, true);
		assertTrue(c.isIncendie());
		assertTrue(c.isVandalisme());
		assertTrue(c.isInondation());
		
		c = new Couverture(false, false, false);
		assertFalse(c.isIncendie());
		assertFalse(c.isVandalisme());
		assertFalse(c.isInondation());
	}

	public void billingSettersTests(){
		Couverture c = new Couverture(false, false, false);
		assertFalse(c.isIncendie());
		assertFalse(c.isVandalisme());
		assertFalse(c.isInondation());
		
		c.setIncendie(true);
		c.setInondation(true);
		c.setVandalisme(true);
		assertTrue(c.isIncendie());
		assertTrue(c.isVandalisme());
		assertTrue(c.isInondation());
	}
}
