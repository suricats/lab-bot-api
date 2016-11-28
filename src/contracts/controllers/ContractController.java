package contracts.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contracts.domain.Billing;
import contracts.domain.Contract;
import contracts.domain.Couverture;
import contracts.domain.PartyRole;
import contracts.domain.Risk;
import utils.FakeDataGenerator;
import utils.Link;

@RestController
@RequestMapping("/insurance/contract")
public class ContractController {

	@RequestMapping(value = {"", "/"}, produces = "application/json ; charset=UTF-8")
	public String index() {
		return "What else ??";
	}
	
	@RequestMapping(value="ID-{idContrat}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Contract> getContract(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {

		return new ResponseEntity<Contract>(FakeDataGenerator.getFakeContrat(idContrat), HttpStatus.OK);
	}

	/////////////////////////RISK/////////////////////////
	@RequestMapping(value="ID-{idContrat}/risk", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getRisk(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {

		List<Risk> risk = FakeDataGenerator.getFakeContrat(idContrat).getObjetsCouverts();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<risk.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<risk.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getCouverture(request,idContrat,risk.get(i).getIdentifiant())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/risk/ID-{idObject}/couverture", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Couverture> getCouverture(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idObject") String idObject) {

		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getObjetsCouverts().size());
		return new ResponseEntity<Couverture>(c.getObjetsCouverts().get(rand).getCouverture(), HttpStatus.OK);
	}


	/////////////////////////BILLING/////////////////////////
	@RequestMapping(value="ID-{idContrat}/billings", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getBillings(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {

		List<Billing> billings = FakeDataGenerator.getFakeContrat(idContrat).getBillings();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<billings.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<billings.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getBilling(request,idContrat,billings.get(i).getIdentifiant())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/billings/ID-{idBilling}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Billing> getBilling(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {

		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getBillings().size());
		return new ResponseEntity<Billing>(c.getBillings().get(rand), HttpStatus.OK);
	}

	/////////////////////////PARTYROLE/////////////////////////
	@RequestMapping(value="ID-{idContrat}/partyRoles", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getPartyRoles(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {

		List<PartyRole> partyRoles = FakeDataGenerator.getFakeContrat(idContrat).getPartyRoles();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<partyRoles.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<partyRoles.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getPartyRole(request,idContrat,partyRoles.get(i).getIdentifiant())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/partyRoles/ID-{idBilling}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<PartyRole> getPartyRole(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {

		Contract c = FakeDataGenerator.getFakeContrat(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getPartyRoles().size());
		return new ResponseEntity<PartyRole>(c.getPartyRoles().get(rand), HttpStatus.OK);
	}

}