package kesmarki.personapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import kesmarki.personapp.dto.PersonsContactsAddresses;
import kesmarki.personapp.services.DataQueryServices;

@RestController
public class DataQueryController {

	@Autowired
	DataQueryServices dataQueryServices;

	@GetMapping("/personsContactsAddresses")
	public ResponseEntity<List<PersonsContactsAddresses>> getPersonsContactsDetails() {
		try {
			return new ResponseEntity<List<PersonsContactsAddresses>>(dataQueryServices.personsContactsAddresses(),
					HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
