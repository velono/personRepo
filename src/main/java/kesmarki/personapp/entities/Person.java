package kesmarki.personapp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Person {

	@Id

	@SequenceGenerator(name = "person-seq-gen", initialValue = 6, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person-seq-gen")
	private Long id;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "contactid")
	private Long contactId;

	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contactid", insertable = false, updatable = false) // Changed from "contactid" to "id".
	@JsonBackReference("cont_person")
	private Contact contact;

	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonManagedReference("person_addr")
	private List<Address> addresses;

	public Person() {
	}

	public Person(Long id, String lastName, String firstName, Long contactId) {
		super();
		this.id = id;
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

	public Contact getContact() {
		return contact;
	}

	public List<Address> getAddresses() {
		return addresses;
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

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", contactId=" + contactId
				+ ", contact=" + contact + ", addresses=" + addresses + "]";
	}

}
