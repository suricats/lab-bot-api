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
	private List<PartyRole> partyRoles = new ArrayList<>();
	
	public Contracts(){}
	
	public Contracts(String identifiant){
		super();
		this.identifiant=identifiant;
		
		/////////Creation des risk//////////
		Risk r=new Risk("kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(true,true,true));
		this.objetCouvert.add(r);
		r=new Risk("kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(false,false,false));
		this.objetCouvert.add(r);
		Risk r2=new Risk("52665236","maison",1000, 100, "RC2", "05-11-2016", new Couverture(true,false,true));
		this.objetCouvert.add(r2);
		
		/////////Creation des billing//////////
		Billing b=new Billing("96268885",123.97, Frequency.annuelle, "2016-11-10", MethodPaiement.prelevement);
		this.billings.add(b);
		b=new Billing("2355596664",542.97, Frequency.mensuel, "2016-11-10", MethodPaiement.cheque);
		this.billings.add(b);
		b=new Billing("123987456",542.97, Frequency.hebdomadaire, "2017-11-10", MethodPaiement.cheque);
		this.billings.add(b);
		
		/////////Creation des partyRole//////////	
		PartyRole pr=new PartyRole("eee78595","2016-12-25", 
				new Person("1994-12-05", "5639358", "first_name", "last_name", "93700"),
				"owner");
		partyRoles.add(pr);
		pr=new PartyRole("eee787634", "2016-12-25", 
				new Person("1994-12-05", "7596055", "first_name", "last_name", "75005"),
				"owner");
		partyRoles.add(pr);
		
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

	public List<PartyRole> getPartyRoles() {
		return partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

}
