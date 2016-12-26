package contracts.domain;

import java.util.ArrayList;
import java.util.List;

public class Contract {

	private String identifiant;
	private List<Risk> objetsCouverts = null;
	private List<Billing> billings = null;
	private List<PartyRole> partyRoles = null;

	public Contract(){}

	public Contract(String identifiant){
		super();
		this.identifiant=identifiant;
	}

	public Contract(String identifiant, List<Risk> objetsCouverts, List<Billing> billings, List<PartyRole> partyRoles){
		super();
		this.identifiant = identifiant;
		if(objetsCouverts != null) this.objetsCouverts = new ArrayList<>(objetsCouverts);
		if(billings != null) this.billings = new ArrayList<>(billings);
		if(partyRoles != null) this.partyRoles = new ArrayList<>(partyRoles);
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public List<Risk> getObjetsCouverts() {
		return objetsCouverts;
	}

	public void setObjetsCouverts(List<Risk> objetsCouverts) {
		this.objetsCouverts = objetsCouverts;
	}

	public void addObjetCouvert(Risk objetCouvert) {
		if(this.objetsCouverts==null) objetsCouverts = new ArrayList<>();
		this.objetsCouverts.add(objetCouvert);
	}

	public List<Billing> getBillings() {
		return billings;
	}

	public void setBillings(List<Billing> billings) {
		this.billings = billings;
	}

	public void addBilling(Billing billing) {
		if(this.billings==null) billings = new ArrayList<>();
		this.billings.add(billing);
	}

	public List<PartyRole> getPartyRoles() {
		return partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

	public void addPartyRole(PartyRole partyRole) {
		if(this.partyRoles==null) partyRoles = new ArrayList<>();
		this.partyRoles.add(partyRole);
	}

}
