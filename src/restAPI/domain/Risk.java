package restAPI.domain;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Risk extends ResourceSupport{
	
	private String identifiant;
	private String name;
	private String content;
	private int montant;
	private int bonusMalus;
	private String label;
	private String end_date;
	private Couverture couverture;
	
	@JsonCreator
    public Risk(@JsonProperty("content") String content) {
        this.content = content;
    }
	
	public Risk(){}
	
	public Risk(String identifiant,String name,int montant, int bonusMalus,
			String label, String end_date, Couverture couverture){
		super();
		this.identifiant=identifiant;
		this.name=name;
		this.montant=montant;
		this.bonusMalus=bonusMalus;
		this.label=label;
		this.end_date=end_date;
		this.couverture=couverture;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getBonusMalus() {
		return bonusMalus;
	}

	public void setBonusMalus(int bonusMalus) {
		this.bonusMalus = bonusMalus;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public Couverture getCouverture(){
		return couverture;
	}
	
	public void setCouverture(Couverture couverture){
		this.couverture = couverture;
	}
	
	public String getContent() {
        return content;
    }
}
