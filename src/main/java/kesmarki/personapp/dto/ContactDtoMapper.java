package kesmarki.personapp.dto;

import kesmarki.personapp.entities.Contact;

public class ContactDtoMapper {

	public Contact toContact(ContactDTO contactDTO) {
		Contact contact = new Contact();
		contact.setEmail(contactDTO.getEmail());
		contact.setTel(contactDTO.getTel());
		return contact;
	}

	public ContactDTO toDTO(Contact contact) {
		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setId(contact.getId());
		contactDTO.setEmail(contact.getEmail());
		contactDTO.setTel(contact.getTel());
		return contactDTO;
	}
}
