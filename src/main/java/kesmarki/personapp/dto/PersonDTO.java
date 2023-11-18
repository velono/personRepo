package kesmarki.personapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonDTO {

	Long id;

	@NotBlank(message = "Lastname can't be null.")
	String lastName;

	@NotBlank(message = "Firstname can't be null.")
	String firstName;

	Long contactId;

	public PersonDTO() {

	}

	public PersonDTO(Long id, String lastName, String firstName, Long contactId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactId = contactId;
	}

	public PersonDTO(String lastName, String firstName, Long contactId) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactId = contactId;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", contactId="
				+ contactId + "]";
	}

}