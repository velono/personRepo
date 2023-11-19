package kesmarki.personapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
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
		try {
			return new ResponseEntity<PersonDTO>(personService.getPersonById(id), HttpStatus.OK);
		} catch (WrongInputException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/getPerson/{lastName}/{firstName}")
	public ResponseEntity<List<PersonDTO>> getPerson(@PathVariable("lastName") String lastName,
			@PathVariable("firstName") String firstName) {
		return new ResponseEntity<List<PersonDTO>>(personService.getPersonByName(lastName, firstName), HttpStatus.OK);
	}

	@GetMapping("/getPeopleFromCity/{city}")
	public ResponseEntity<List<PersonDTO>> getPeopleFromCity(@PathVariable String city) {
		try {
			return new ResponseEntity<List<PersonDTO>>(personService.getPersonByCity(city), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/getEverybody")
	public ResponseEntity<List<PersonDTO>> getEverybody() {
		return new ResponseEntity<List<PersonDTO>>(personService.getEverybody(), HttpStatus.OK);
	}

	@Transactional
	@PutMapping("/updateperson")
	public ResponseEntity<String> updatePerson(@Valid @RequestBody PersonDTO personDTO) {
		try {
			return new ResponseEntity<String>(personService.updatePerson(personDTO), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@Transactional
	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		try {
			personService.deletePersonById(id);
			return new ResponseEntity<String>("Person " + id + " deleted.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
