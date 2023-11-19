package kesmarki.personapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kesmarki.personapp.dto.PersonsContactsAddresses;
import kesmarki.personapp.repository.PersonRepository;

@Service
public class DataQueryServices {
	@Autowired
	private PersonRepository personRepository;

	public List<PersonsContactsAddresses> personsContactsAddresses() {
		return personRepository.personsContactsAddresses();
	}

}
