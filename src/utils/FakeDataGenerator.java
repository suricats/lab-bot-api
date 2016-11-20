package utils;

import contracts.domain.Billing;
import contracts.domain.Contract;
import contracts.domain.Couverture;
import contracts.domain.Frequency;
import contracts.domain.PartyRole;
import contracts.domain.PayementMethod;
import contracts.domain.Person;
import contracts.domain.Risk;

public class FakeDataGenerator {
	
	public static Person pers1 = new Person("1999-18-09","563155","felix","grt","75005");
	public static Person pers2 = new Person("1999-19-09","563155","julien","mrgrd","75005");
	public static Person pers3 = new Person("1999-20-09","563155","anna","kstrkv","75005");
	public static Person pers = new Person("1999-20-09","563155","philippe","arthaux","75005");
	
	public static Contract getFakeContrat(String idContrat){
		Contract contrat = new Contract(idContrat);
		
		contrat.addObjetCouvert(new Risk("kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(true,true,true)));
		contrat.addObjetCouvert(new Risk("kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(false,false,false)));
		contrat.addObjetCouvert(new Risk("52665236","maison",1000, 100, "RC2", "05-11-2016", new Couverture(true,false,true)));
		
		contrat.addBilling(new Billing("96268885",123.97, Frequency.annuel, "2016-11-10", PayementMethod.prelevement));
		contrat.addBilling(new Billing("2355596664",542.97, Frequency.mensuel, "2016-11-10", PayementMethod.cheque));
		contrat.addBilling(new Billing("123987456",542.97, Frequency.hebdomadaire, "2017-11-10", PayementMethod.cheque));
		
		contrat.addPartyRole(new PartyRole("eee78595","2016-12-25", new Person("1994-12-05", "5639358", 
				"thomas", "dupont", "93700"), "owner"));
		contrat.addPartyRole(new PartyRole("eee787634", "2016-12-25", new Person("1994-12-05", "7596055", 
				"eric", "dupuit", "75005"), "owner"));
		return contrat;
	}
	
}
