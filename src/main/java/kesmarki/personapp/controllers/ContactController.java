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
import kesmarki.personapp.dto.ContactDTO;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.services.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	// Add
	@PostMapping("/addContact")
	public ResponseEntity<String> addContactDetails(@Valid @RequestBody ContactDTO contactDTO) {
		try {
			return new ResponseEntity<String>(contactService.addContact(contactDTO), HttpStatus.OK);
		} catch (WrongInputException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Read
	@GetMapping("/getAllContacts")
	public ResponseEntity<List<ContactDTO>> getAllContacts() {
		return new ResponseEntity<List<ContactDTO>>(contactService.getAllContacts(), HttpStatus.OK);
	}

	// Update

	@Transactional
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(@Valid @RequestBody ContactDTO contactDTO) {
		try {
			return new ResponseEntity<String>(contactService.updateContact(contactDTO), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Delete
	@Transactional
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		try {
			contactService.deleteContactById(id);
			return new ResponseEntity<String>("Contact " + id + " deleted.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
