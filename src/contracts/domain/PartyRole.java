package contracts.domain;

public class PartyRole {

	private String identifiant;
	private String end_date;
	private String image;
	private Person person;
	private String type;
	
	public PartyRole(String identifiant){
		this.identifiant = identifiant;
	}
	
	public PartyRole(String identifiant, String end_date, String image, Person person, String type){
		this.identifiant=identifiant;
		this.end_date=end_date;
		this.image=image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
