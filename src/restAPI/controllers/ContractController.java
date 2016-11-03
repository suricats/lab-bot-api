package restAPI.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import restAPI.domain.Billing;
import restAPI.domain.Contracts;
import restAPI.domain.Couverture;
import restAPI.domain.PartyRole;
import restAPI.domain.Risk;
import utils.Link;

@RestController
@RequestMapping("/insurance/contract")
public class ContractController {

	@RequestMapping(value = {"", "/"}, produces = "application/json")
	public String index() {
		return "What else ??";
	}

	@RequestMapping(value="ID-{idContrat}", produces = "application/json")
	public ResponseEntity<Contracts> getContract(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		
		return new ResponseEntity<Contracts>(new Contracts(idContrat), HttpStatus.OK);
	}

	/////////////////////////RISK/////////////////////////
	@RequestMapping(value="ID-{idContrat}/risk", produces = "application/json")
	public ResponseEntity<List<Link>> getRisk(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		
		List<Risk> risk = new Contracts(idContrat).getObjetCouvert();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<risk.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<risk.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getCouverture(request,idContrat,risk.get(i).getIdentifiant(),"lll")).withSelfRel());
			/*risk.get(i).add(linkTo(methodOn(ContractController.class).
					getBilling(request,idContrat,risk.get(i).getIdentifiant())).withSelfRel());*/
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/risk/ID-{idObject}/couverture", produces = "application/json")
	public ResponseEntity<Couverture> getCouverture(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idObject") String idObject,
			@RequestParam(value="inquiry") String name) {
		
		Contracts c = new Contracts(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getBillings().size());
		System.out.println(rand);
		return new ResponseEntity<Couverture>(c.getObjetCouvert().get(rand).getCouverture(), HttpStatus.OK);
	}


	/////////////////////////BILLING/////////////////////////
	@RequestMapping(value="ID-{idContrat}/billings", produces = "application/json")
	public ResponseEntity<List<Link>> getBillings(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		
		List<Billing> billings = new Contracts(idContrat).getBillings();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<billings.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<billings.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getBilling(request,idContrat,billings.get(i).getIdentifiant())).withSelfRel());
			/*billings.get(i).add(linkTo(methodOn(ContractController.class).
					getBilling(request,idContrat,billings.get(i).getIdentifiant())).withSelfRel());*/
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}

	@RequestMapping(value="ID-{idContrat}/billings/ID-{idBilling}", produces = "application/json")
	public ResponseEntity<Billing> getBilling(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {

		Contracts c = new Contracts(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getBillings().size());
		System.out.println(rand);
		return new ResponseEntity<Billing>(c.getBillings().get(rand), HttpStatus.OK);
	}

	/////////////////////////PARTYROLE/////////////////////////
	@RequestMapping(value="ID-{idContrat}/partyRoles", produces = "application/json")
	public ResponseEntity<List<Link>> getPartyRoles(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat) {
		
		List<PartyRole> partyRoles = new Contracts(idContrat).getPartyRoles();
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<partyRoles.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<partyRoles.size();i++){
			listLink.get(i).add(linkTo(methodOn(ContractController.class).
					getPartyRole(request,idContrat,partyRoles.get(i).getIdentifiant())).withSelfRel());
			/*billings.get(i).add(linkTo(methodOn(ContractController.class).
					getBilling(request,idContrat,billings.get(i).getIdentifiant())).withSelfRel());*/
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}
	
	@RequestMapping(value="ID-{idContrat}/partyRoles/ID-{idBilling}", produces = "application/json")
	public ResponseEntity<PartyRole> getPartyRole(HttpServletRequest request,
			@PathVariable("idContrat") String idContrat,
			@PathVariable("idBilling") String idBilling) {
		
		Contracts c = new Contracts(idContrat);
		Random random = new Random();
		int rand = random.nextInt(c.getBillings().size());
		System.out.println(rand);
		return new ResponseEntity<PartyRole>(c.getPartyRoles().get(rand), HttpStatus.OK);
	}

}