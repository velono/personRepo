package kesmarki.personapp.dto;

public class PersonsContactsAddresses {
	private Long personId;
	private String lastName;
	private String firstName;
	private Long contactId;
	private String email;
	private String tel;
	private String city;
	private String streetName;
	private String streetType;
	private Long number;
	private Boolean permanent;

	public PersonsContactsAddresses() {
	}

	public PersonsContactsAddresses(Long personId, String lastName, String firstName, Long contactId, String email,
			String tel, String city, String streetName, String streetType, Long number, Boolean permanent) {
		super();
		this.personId = personId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.contactId = contactId;
		this.email = email;
		this.tel = tel;
		this.city = city;
		this.streetName = streetName;
		this.streetType = streetType;
		this.number = number;
		this.permanent = permanent;
	}

	public Long getPersonId() {
		return personId;
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

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public String getCity() {
		return city;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getStreetType() {
		return streetType;
	}

	public Long getNumber() {
		return number;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public void setPermanent(Boolean permanent) {
		this.permanent = permanent;
	}

	@Override
	public String toString() {
		return "PersonsContactsAddresses [personId=" + personId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", contactId=" + contactId + ", email=" + email + ", tel=" + tel + ", city=" + city + ", streetName="
				+ streetName + ", streetType=" + streetType + ", number=" + number + ", permanent=" + permanent + "]";
	}

}
