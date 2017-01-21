package contracts.utils;

import contracts.domain.Billing;
import contracts.domain.Contract;
import contracts.domain.Couverture;
import contracts.domain.Frequency;
import contracts.domain.PartyRole;
import contracts.domain.PayementMethod;
import contracts.domain.Person;
import contracts.domain.Rib;
import contracts.domain.Risk;

public class FakeDataGenerator {
	
	public static Person pers1 = new Person("1999-18-09","5631851","felix","grt","75005");
	public static Person pers2 = new Person("1999-19-09","1781566","julien","mrgrd","75005");
	public static Person pers3 = new Person("1999-20-09","0684000","anna","kstrkv","75005");
	public static Person pers = new Person("1999-20-09","563155","philippe","arthaux","75005");
	
	public static Contract getFakeContrat(String idContrat){
		Contract contrat = new Contract(idContrat);
		
		contrat.addObjetCouvert(new Risk("02453620","voiture",250, 100, "RC", "05-11-2016", new Couverture(true,true,true)));
		contrat.addObjetCouvert(new Risk("8944710","voiture",250, 100, "RC", "05-11-2016", new Couverture(false,false,false)));
		contrat.addObjetCouvert(new Risk("52665236","maison",1000, 100, "RC2", "05-11-2016", new Couverture(true,false,true)));
		
		contrat.addBilling(new Billing("96268885",123.97, Frequency.annuel, "2016-11-10", PayementMethod.prelevement));
		contrat.addBilling(new Billing("2355596664",542.97, Frequency.mensuel, "2016-11-10", PayementMethod.cheque));
		contrat.addBilling(new Billing("123987456",542.97, Frequency.hebdomadaire, "2017-11-10", PayementMethod.cheque));
		
		contrat.addPartyRole(new PartyRole("78595","2016-12-25",
				"http://animalfactguide.com/wp-content/uploads/2013/01/iStock_000006798074XSmall.jpg",
				new Person("1994-12-05", "5639358", 
				"thomas", "dupont", "93700"), "owner"));
		contrat.addPartyRole(new PartyRole("787634", "2016-12-25",
				"http://www.suricats-consulting.com/wp-content/uploads/2016/05/A1-01-150x150.png",
				new Person("1994-12-05", "7596055", 
				"eric", "dupuit", "75005"), "owner"));
		
		contrat.addRib(new Rib("https://mabanque.bnpparibas/rsc/contrib/image/particuliers/gabarits-libres/rib.jpg"));
		return contrat;
	}

	public static Risk getFakeRisk() {
		return new Risk("kockeo","voiture",250, 100, "RC", "05-11-2016", new Couverture(true,true,true));
	}

	public static PartyRole getFakePartyRole() {
		return new PartyRole("eee78595","2016-12-25",
				"http://www.suricats-consulting.com/wp-content/uploads/2016/05/A1-01-150x150.png",
				new Person("1994-12-05", "5639358", 
				"thomas", "dupont", "93700"), "owner");
	}
	
	public static Billing getFakeBilling() {
		return new Billing("96268885",123.97, Frequency.annuel, "2016-11-10", PayementMethod.prelevement);
	}
	
	public static Couverture getFakeCouvertureAllTrue() {
		return new Couverture(true, true, true);
	}
	
	public static Rib getFakeRib(){
		return new Rib("http://images.google.fr/imgres?imgurl=https%3A%2F%2Fmabanque.bnpparibas%2Frsc%2Fcontrib%2Fimage%2Fparticuliers%2Fgabarits-libres%2Frib.jpg&imgrefurl=https%3A%2F%2Fmabanque.bnpparibas%2Ffr%2Fnotre-offre%2Fcomptes-cartes-et-services%2Fgerer-ses-comptes-et-son-budget%2Fgerer-ses-comptes-en-ligne%2Ftutoriels-videos%2Fediter-un-rib&h=944&w=2399&tbnid=ial72vnuV6NdPM%3A&vet=1&docid=mh5__rRIxzuXkM&ei=G914WIiGDoTcaIj4lpAO&tbm=isch&client=firefox-b-ab&iact=rc&uact=3&dur=393&page=0&start=0&ndsp=15&ved=0ahUKEwjI_8Leo7_RAhUELhoKHQi8BeIQMwgcKAAwAA&bih=633&biw=1366");
	}
}
