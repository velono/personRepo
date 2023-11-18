package kesmarki.personapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import kesmarki.personapp.dto.PersonDTO;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/addperson")
	public ResponseEntity<String> addPerson(@Valid @RequestBody PersonDTO personDTO) {
		try {
			return new ResponseEntity<String>(personService.addPerson(personDTO), HttpStatus.OK);
		} catch (WrongInputException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}

	@GetMapping("/getPerson/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable("id") Long id) {

		return new ResponseEntity<PersonDTO>(personService.getPersonById(id), HttpStatus.OK);

	}
}
