package restAPI.domain;

import org.springframework.hateoas.ResourceSupport;

public class Couverture extends ResourceSupport{

	private boolean incendie;
	private boolean inondation;
	private boolean vandalisme;
	
	public Couverture(){}
	
	public Couverture(boolean inondation, boolean incendie, boolean vandalisme){
		this.incendie=incendie;
		this.inondation=inondation;
		this.vandalisme=vandalisme;
	}

	public boolean isIncendie() {
		return incendie;
	}

	public void setIncendie(boolean incendie) {
		this.incendie = incendie;
	}

	public boolean isInondation() {
		return inondation;
	}

	public void setInondation(boolean inondation) {
		this.inondation = inondation;
	}

	public boolean isVandalisme() {
		return vandalisme;
	}

	public void setVandalisme(boolean vandalisme) {
		this.vandalisme = vandalisme;
	}
}
