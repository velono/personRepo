package kesmarki.personapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kesmarki.personapp.dto.PersonDTO;
import kesmarki.personapp.services.PersonService;


@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getPerson/{id}")
	public ResponseEntity<PersonDTO> getPerson (@PathVariable("id") Long id){
	
		return new ResponseEntity<PersonDTO>(personService.getPersonById(id), HttpStatus.OK);


	}
}
