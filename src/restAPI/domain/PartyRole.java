package restAPI.domain;

import org.springframework.hateoas.ResourceSupport;

public class PartyRole extends ResourceSupport  {

	private String identifiant;
	private String end_date;
	private Person person;
	private String type;
	
	public PartyRole(String identifiant, String end_date, Person person, String type){
		this.identifiant=identifiant;
		this.end_date=end_date;
		this.person=person;
		this.type=type;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
