package restAPI.controllers;

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
    public ResponseEntity<List<Risk>> getRisk(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat) {
		System.out.println(idContrat);
		List<Risk> greeting = new Contracts(idContrat).getObjetCouvert();
		for(int i=0; i<greeting.size();i++){
			greeting.get(i).add(linkTo(methodOn(ContractController.class).
					getCouverture(request,idContrat,greeting.get(i).getIdentifiant(),"lll")).withSelfRel());
		}
		return new ResponseEntity<List<Risk>>(greeting, HttpStatus.OK);
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
    public ResponseEntity<List<Billing>> getBillings(HttpServletRequest request,
    		@PathVariable("idContrat") String idContrat) {
		 System.out.println("dans getBillings");
		 return new ResponseEntity<List<Billing>>(new Contracts(idContrat).getBillings(), HttpStatus.OK);
    }
		
}