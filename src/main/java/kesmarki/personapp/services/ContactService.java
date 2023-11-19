package kesmarki.personapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kesmarki.personapp.dto.ContactDTO;
import kesmarki.personapp.dto.ContactDtoMapper;
import kesmarki.personapp.entities.Contact;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	private final ContactDtoMapper contactDtoMapper = new ContactDtoMapper();

	// Add new contact
	public String addContact(ContactDTO contactDTO) throws WrongInputException {
		if (contactDTO.getEmail() == null || contactDTO.getTel() == null) {
			throw new WrongInputException("Email and Tel can't be null;");
		}
		try {
			Contact addedContact = contactRepository.save(contactDtoMapper.toContact(contactDTO));
			return "Contact details added with id: " + addedContact.getId();
		} catch (DataIntegrityViolationException e) {
			throw new WrongInputException("Email already exists.");
		}
	}

	// Retrieve
	public List<ContactDTO> getAllContacts() {
		List<Contact> contactList = contactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		List<ContactDTO> dtoList = new ArrayList<>();
		for (Contact c : contactList) {
			dtoList.add(contactDtoMapper.toDTO(c));
		}
		return dtoList;
	}

	// Update
	public String updateContact(@Valid ContactDTO contactDTO) throws WrongInputException {
		Contact contact = contactRepository.findById(contactDTO.getId()).orElseThrow();
		if (contactDTO.getEmail() == null || contactDTO.getTel() == null) {
			throw new WrongInputException("Email and Tel can't be null;");
		}
		contact.setEmail(contactDTO.getEmail());
		contact.setTel(contactDTO.getTel());
		return "Contact updated. " + contact.getId();
	}

	// Delete
	public void deleteContactById(Long id) {
		contactRepository.findById(id).orElseThrow();
		contactRepository.deleteById(id);
	}
}
