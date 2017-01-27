package contracts.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contracts.domain.Billing;
import contracts.domain.Contract;
import contracts.domain.Couverture;
import contracts.domain.PartyRole;
import contracts.domain.Rib;
import contracts.domain.Risk;
import contracts.utils.FakeDataGenerator;

@RestController
@RequestMapping("/insurance/contract")
public class ContractController {
	
	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = {"", "/"}, produces = "application/json ; charset=UTF-8")
	public String index() {
		logger.error("Test log");
		return "What else ??";
	}
	
	@RequestMapping(value="ID-{idContrat}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Contract> getContract(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		logger.error("Test log");
		return new ResponseEntity<Contract>(FakeDataGenerator.getFakeContrat(idContrat), HttpStatus.OK);
	}

	/////////////////////////RISK/////////////////////////
	@RequestMapping(value="ID-{idContrat}/risk", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getCouvertureChoice(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		logger.info("getCouvertureChoice");
		List<Risk> risk = FakeDataGenerator.getFakeContrat(idContrat).getObjetsCouverts();
		List<Link> listLink = new ArrayList<>();
		for(int i=0; i<risk.size();i++){
			listLink.add(linkTo(methodOn(ContractController.class).
					getCouvertureInfo(request,idContrat,risk.get(i).getIdentifiant())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/risk/ID-{idObject}/couverture", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Couverture> getCouvertureInfo(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idObject") String idObject) {
		logger.info("getCouvertureInfo");

		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getObjetsCouverts().size());
		return new ResponseEntity<Couverture>(c.getObjetsCouverts().get(rand).getCouverture(), HttpStatus.OK);
	}


	/////////////////////////BILLING/////////////////////////
	@RequestMapping(value="ID-{idContrat}/billings", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getBillingChoice(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		logger.info("getBillingChoice");
		List<Billing> billings = FakeDataGenerator.getFakeContrat(idContrat).getBillings();
		List<Link> listLink = new ArrayList<>();
		
		for(int i=0; i<billings.size();i++){
			listLink.add(linkTo(methodOn(ContractController.class).
					getBillingInfo(request,idContrat,billings.get(i).getIdentifiant())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/billings/ID-{idBilling}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Billing> getBillingInfo(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {
		logger.info("getBillingInfo");
		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getBillings().size());
		logger.error("Test log");
		return new ResponseEntity<Billing>(c.getBillings().get(rand), HttpStatus.OK);
	}

	/////////////////////////PARTYROLE/////////////////////////
	@RequestMapping(value="ID-{idContrat}/partyRoles", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getPartyRoleChoice(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		logger.info("getPartyRoleChoice");
		List<PartyRole> partyRoles = FakeDataGenerator.getFakeContrat(idContrat).getPartyRoles();
		List<Link> listLink = new ArrayList<>();
		String fullName;
		for(int i=0; i<partyRoles.size();i++){
			fullName=partyRoles.get(i).getPerson().getFirst_name()+" "+partyRoles.get(i).getPerson().getLast_name();
			listLink.add(linkTo(methodOn(ContractController.class).
					getPartyRoleInfo(request,idContrat,partyRoles.get(i).getIdentifiant()+":::"+fullName)).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/partyRoles/ID-{idBilling}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<PartyRole> getPartyRoleInfo(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {
		logger.info("getPartyRoleInfo");
		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		int rand = new Random().nextInt(c.getPartyRoles().size());
		return new ResponseEntity<PartyRole>(c.getPartyRoles().get(rand), HttpStatus.OK);
	}
	
	@RequestMapping(value="ID-{idContrat}/partyRoles/ID-{idBilling}/name", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<String> getPartyRoleName(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {
		logger.info("getPartyRoleName");
		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getPartyRoles().size());
		String fullName = c.getPartyRoles().get(rand).getPerson().getFirst_name() +" " + c.getPartyRoles().get(rand).getPerson().getLast_name();
		return new ResponseEntity<String>(fullName, HttpStatus.OK);
	}
	
	/////////////////////////RIB/////////////////////////
	@RequestMapping(value="ID-{idContrat}/rib", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Rib> getRib(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		logger.info("getRib");
		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		return new ResponseEntity<Rib>(c.getListRib().get(0), HttpStatus.OK);
	}

}