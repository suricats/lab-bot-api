package restAPI.domain;

public class Person {

	private String birth_date;
	private String client_number;
	private String first_name;
	private String last_name;
	private String postal_code;
	
	public Person(){}
	
	public Person(String birth_date, String client_number,
			String first_name, String last_name,
			String postal_code){
		super();
		this.birth_date=birth_date;
		this.client_number=client_number;
		this.first_name=first_name;
		this.last_name=last_name;
		this.postal_code=postal_code;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getClient_number() {
		return client_number;
	}

	public void setClient_number(String client_number) {
		this.client_number = client_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
}
