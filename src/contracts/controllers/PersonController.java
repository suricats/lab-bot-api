package contracts.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contracts.domain.Person;
import utils.FakeDataGenerator;
import utils.Link;

@RestController
@RequestMapping("/insurance/persons")
public class PersonController {

	@RequestMapping(value={"","/"}, produces = "application/json ; charset=UTF-8")
	public ResponseEntity<List<Link>> getListPersons(HttpServletRequest request) {
		List<Person> lp = new ArrayList<>();
		lp.add(FakeDataGenerator.pers1);
		lp.add(FakeDataGenerator.pers2);
		lp.add(FakeDataGenerator.pers3);
		List<Link> listLink = new ArrayList<>();
		for(int j=0; j<lp.size();j++){
			listLink.add(new Link());
		}
		for(int i=0; i<lp.size();i++){
			listLink.get(i).add(linkTo(methodOn(PersonController.class).
					getPerson(request,lp.get(i).getClient_number())).withSelfRel());
		}
		return new ResponseEntity<List<Link>>(listLink, HttpStatus.OK);
	}
	
	@RequestMapping(value="PE{clientNumber}", produces = "application/json ; charset=UTF-8")
	public ResponseEntity<Person> getPerson(HttpServletRequest request,
			@PathVariable("clientNumber") String clientNumber) {
		Person p = FakeDataGenerator.pers;
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}

}