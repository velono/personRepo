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
import kesmarki.personapp.dto.AddressDTO;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	// Add
	@PostMapping("/addAddress")
	public ResponseEntity<String> addAddressDetails(@Valid @RequestBody AddressDTO addressDTO) {
		try {
			return new ResponseEntity<String>(addressService.addAddress(addressDTO), HttpStatus.OK);
		} catch (WrongInputException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Read
	@GetMapping("/getAllAddresses")
	public ResponseEntity<List<AddressDTO>> getAllAddresss() {
		return new ResponseEntity<List<AddressDTO>>(addressService.getAllAddress(), HttpStatus.OK);
	}

	// Update

	@Transactional
	@PutMapping("/updateAddress")
	public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDTO addressDTO) {
		try {
			return new ResponseEntity<String>(addressService.updateAddress(addressDTO), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Delete
	@Transactional
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		try {
			addressService.deleteAddressById(id);
			return new ResponseEntity<String>("Address " + id + " deleted.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
