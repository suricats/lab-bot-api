package test.contracts.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import contracts.domain.Person;
import contracts.utils.FakeDataGenerator;

public class PersonTest {
	
	@Test
	public void personConstructorTest(){
		String number = "number";
		String date = "06-06";
		String first = "first", last = "last";
		String code = "code";
		
		Person p = new Person(date, number, first, last, code);
		assertEquals(p.getBirth_date(), date);
		assertEquals(p.getClient_number(), number);
		assertEquals(p.getFirst_name(), first);
		assertEquals(p.getLast_name(), last);
		assertEquals(p.getPostal_code(), code);
	}
	
	public void personSettersTest(){
		String number = "number";
		String date = "06-06";
		String first = "first", last = "last";
		String code = "code";
		
		Person p = FakeDataGenerator.pers;
		p.setBirth_date(date);
		p.setClient_number(number);
		p.setFirst_name(first);
		p.setLast_name(last);
		p.setPostal_code(code);
		
		assertEquals(p.getBirth_date(), date);
		assertEquals(p.getClient_number(), number);
		assertEquals(p.getFirst_name(), first);
		assertEquals(p.getLast_name(), last);
		assertEquals(p.getPostal_code(), code);
	}


}
