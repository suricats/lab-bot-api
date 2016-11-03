package restAPI.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import restAPI.domain.Risk;
import utils.Link;

@RestController
@RequestMapping("/insurance/contract")
public class ContractController {

	@RequestMapping(value = {"", "/"}, produces = "application/json")
    public String index() {
        return "What else ??";
    }
	
	@RequestMapping(value="ID{idContrat}", produces = "application/json")
    public ResponseEntity<Contracts> getContract(HttpServletRequest request,
    		HttpServletResponse resp, 
    		@PathVariable("idContrat") String idContrat) {
		resp.setContentType("application/json");
	 	return new ResponseEntity<Contracts>(new Contracts(idContrat), HttpStatus.OK);
    }
	
	/////////////////////////RISK/////////////////////////
	@RequestMapping(value="ID{idContrat}/risk", produces = "application/json")
    public ResponseEntity<List<Link>> getRisk(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat) {
		System.out.println(idContrat);
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
	
	@RequestMapping(value="ID{idContrat}/risk/ID{idObject}/couverture", produces = "application/json")
    public ResponseEntity<Couverture> getCouverture(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat,
    		@PathVariable("idObject") String idObject,
    		@RequestParam(value="inquiry") String name) {
		System.out.println("dans getCouverture");
		return new ResponseEntity<Couverture>(new Contracts(idContrat).getObjetCouvert().get(0).getCouverture(), HttpStatus.OK);
    }
	

	/////////////////////////BILLING/////////////////////////
	@RequestMapping(value="ID{idContrat}/billings", produces = "application/json")
    public ResponseEntity<List<Link>> getBillings(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat) {
		System.out.println("dans getBillings");
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
	
	@RequestMapping(value="ID{idContrat}/billings/ID{idBilling}", produces = "application/json")
    public ResponseEntity<Billing> getBilling(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat,
    		@PathVariable("idBilling") String idBilling) {
		System.out.println("dans getBilling");
		return new ResponseEntity<Billing>(new Contracts(idContrat).getBillings().get(0), HttpStatus.OK);
    }	
	
}