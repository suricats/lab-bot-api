package restAPI.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import restAPI.enumeration.Frequency;
import restAPI.enumeration.MethodPaiement;

public class Contracts extends ResourceSupport {

	private String identifiant;
	private List<Risk> objetCouvert = new ArrayList<Risk>();
	private List<Billing> billings=new ArrayList<Billing>();
	
	public Contracts(){}
	
	public Contracts(String identifiant){
		super();
		this.identifiant=identifiant;
		Risk r=new Risk("ID-kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(true,true,true));
		this.objetCouvert.add(r);

		Risk r2=new Risk("ID-52665236","maison",1000, 100, "RC2", "05-11-2016", new Couverture(true,false,true));
		this.objetCouvert.add(r2);
		
		Billing b=new Billing("ID-96268885",123.97, Frequency.annuelle, "2016-11-10", MethodPaiement.prelevement);
		this.billings.add(b);
		
	}
	
	public Contracts(String identifiant, List<Risk> objetCouvert){
		super();
		this.identifiant=identifiant;
		this.objetCouvert=objetCouvert;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public List<Risk> getObjetCouvert() {
		return objetCouvert;
	}

	public void setObjetCouvert(List<Risk> objetCouvert) {
		this.objetCouvert = objetCouvert;
	}

	public List<Billing> getBillings() {
		return billings;
	}

	public void setBilling(List<Billing> billings) {
		this.billings = billings;
	}

}
