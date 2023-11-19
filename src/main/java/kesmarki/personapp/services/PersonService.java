package kesmarki.personapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kesmarki.personapp.dto.PersonDTO;
import kesmarki.personapp.dto.PersonDtoMapper;
import kesmarki.personapp.entities.Person;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	private final PersonDtoMapper personDtoMapper = new PersonDtoMapper();

	// Add new person
	public String addPerson(PersonDTO personDTO) throws WrongInputException {
		if (personDTO.getFirstName() == null || personDTO.getLastName() == null) {
			throw new WrongInputException("Name fields can't be null;");
		}
		Person addedPerson = personRepository.save(personDtoMapper.toPerson(personDTO));
		return "Person added. " + addedPerson.getId();
	}

	// Retrieve person
	public PersonDTO getPersonById(Long id) {
		Person person = personRepository.getPersonById(id);
		return personDtoMapper.toPersonDTO(person);
	}

	public List<PersonDTO> getPersonByName(String lastName, String firstName) {
		List<Person> personList = personRepository.findByLastNameAndFirstName(lastName, firstName);
		List<PersonDTO> dtoList = new ArrayList<>();
		for (Person p : personList) {
			dtoList.add(personDtoMapper.toPersonDTO(p));
		}
		return dtoList;
	}

	public List<PersonDTO> getPersonByCity(String city) {
		List<Person> personList = personRepository.findByCity(city);
		List<PersonDTO> dtoList = new ArrayList<>();
		for (Person p : personList) {
			dtoList.add(personDtoMapper.toPersonDTO(p));
		}
		return dtoList;
	}

	public List<PersonDTO> getEverybody() {
		List<Person> personList = personRepository.findAll();
		System.out.println("ENNYIEN VANNAK: " + personList.size());
		List<PersonDTO> dtoList = new ArrayList<>();
		for (Person p : personList) {
			dtoList.add(personDtoMapper.toPersonDTO(p));
		}
		return dtoList;
	}

	// Update person
	public String updatePerson(@Valid PersonDTO personDTO) throws WrongInputException {
		if (personDTO.getFirstName() == null || personDTO.getLastName() == null) {
			throw new WrongInputException("Name fields can't be null;");
		}
		Person person = personRepository.findById(personDTO.getId()).orElse(null);
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setContactId(personDTO.getContactId());
		Person p = personRepository.save(person);
		return "Person updated. " + p.getId();
	}

	// Delete person

	//
}
