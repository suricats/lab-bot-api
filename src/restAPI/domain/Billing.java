package restAPI.domain;

import org.springframework.hateoas.ResourceSupport;

import restAPI.enumeration.Frequency;
import restAPI.enumeration.MethodPaiement;

public class Billing extends ResourceSupport {
	
	private String identifiant;
	private double amount;
	private Frequency frequency;
	private String next_date;
	private MethodPaiement methode;
	
	public Billing(String identifiant,double amount, Frequency frequency, String next_date,
			MethodPaiement methode){
		this.identifiant=identifiant;
		this.amount=amount;
		this.frequency=frequency;
		this.next_date=next_date;
		this.methode=methode;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getNext_date() {
		return next_date;
	}

	public void setNext_date(String next_date) {
		this.next_date = next_date;
	}

	public MethodPaiement getMethode() {
		return methode;
	}

	public void setMethode(MethodPaiement methode) {
		this.methode = methode;
	}

}
