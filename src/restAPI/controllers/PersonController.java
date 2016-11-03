package restAPI.controllers;

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

import restAPI.domain.Person;
import utils.Link;

@RestController
@RequestMapping("/insurance/persons")
public class PersonController {

	@RequestMapping(value={"","/"})
	public ResponseEntity<List<Link>> getListPersons(HttpServletRequest request) {
		List<Person> lp = new ArrayList<>();
		Person pers= new Person("1999-18-09","563155","felix","grt","75005");
		Person pers2= new Person("1999-19-09","563155","julien","mrgrd","75005");
		Person pers3= new Person("1999-20-09","563155","anna","kstrkv","75005");
		lp.add(pers);
		lp.add(pers2);
		lp.add(pers3);
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
	
	@RequestMapping(value="PE{clientNumber}", produces = "application/json")
	public ResponseEntity<Person> getPerson(HttpServletRequest request,
			@PathVariable("clientNumber") String clientNumber) {
		Person p = new Person();
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}

}