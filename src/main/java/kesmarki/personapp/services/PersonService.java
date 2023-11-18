package kesmarki.personapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		personRepository.save(personDtoMapper.toPerson(personDTO));
		return "Person added.";
	}

	// Retrieve person
	public PersonDTO getPersonById(Long id) {
		Person person = personRepository.getPersonById(id);
		return personDtoMapper.toPersonDTO(person);
	}
	public List<PersonDTO> getPersonByName (String lastName, String firstName){
		List<Person> personList = personRepository.findByLastNameAndFirstName(lastName, firstName);
		List<PersonDTO> dtoList = new ArrayList<>();
		for(Person p : personList) {
			dtoList.add(personDtoMapper.toPersonDTO(p));
		}
		return dtoList;
	}

	public List<PersonDTO> getPersonByCity(String city) {
		List<Person> personList = personRepository.findByCity(city);
		List<PersonDTO> dtoList = new ArrayList<>();
		for(Person p : personList) {
			dtoList.add(personDtoMapper.toPersonDTO(p));
		}
		return dtoList;
	}

}
