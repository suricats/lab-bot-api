package test.contracts.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contracts.domain.Billing;
import contracts.domain.Frequency;
import contracts.domain.PayementMethod;

public class BillingTest {
	
	@Test
	public void billingTest(){
		String id = "id";
		double amount = 0;
		Frequency frequency = Frequency.annuel;
		String next_date = "date";
		PayementMethod methode = PayementMethod.cheque;
		
		Billing b = new Billing(id, amount, frequency, next_date, methode);
		
		assertEquals(b.getIdentifiant(), id);
		assertEquals(b.getAmount(), amount, 0);
		assertEquals(b.getFrequency(), frequency);
		assertEquals(b.getNext_date(), next_date);
		assertEquals(b.getMethode(), methode);
	}

}
