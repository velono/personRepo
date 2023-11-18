package kesmarki.personapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Person {
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@SequenceGenerator(name="person-seq-gen", initialValue=6, allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="person-seq-gen")
	Long id;

	@Column(name = "lastname")
	String lastName;
	
	@Column(name = "firstname")
	String firstName;
	
	@Column(name = "address_perm")
	Long permanentAddress;
	
	@Column(name = "address_temp")
	Long temporaryAddress;
	
	@Column(name = "contactid")
	Long contactId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Id", insertable = false, updatable = false)
	Contact contact;

	public Person() {}
	public Person(Long id, String lastName, String firstName, Long permanentAddress, Long temporaryAddress,
			Contact contact) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.permanentAddress = permanentAddress;
		this.temporaryAddress = temporaryAddress;
		this.contact = contact;
	}
	
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
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
	public Long getPermanentAddress() {
		return permanentAddress;
	}
	public Long getTemporaryAddress() {
		return temporaryAddress;
	}
	public Contact getContact() {
		return contact;
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
	public void setPermanentAddress(Long permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public void setTemporaryAddress(Long temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", permanentAddress="
				+ permanentAddress + ", temporaryAddress=" + temporaryAddress + "]";
	}
	
	
	

}
