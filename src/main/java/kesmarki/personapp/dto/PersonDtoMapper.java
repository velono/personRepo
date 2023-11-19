package kesmarki.personapp.dto;

import kesmarki.personapp.entities.Person;

public class PersonDtoMapper {

	public Person toPerson(PersonDTO personDTO) {
		Person person = new Person();
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setContactId(personDTO.getContactId());
		return person;
	}

	public PersonDTO toPersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setContactId(person.getContactId());
		return personDTO;
	}
}