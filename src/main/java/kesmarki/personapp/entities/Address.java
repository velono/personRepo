package kesmarki.personapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "address-seq-gen", initialValue = 6, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address-seq-gen")
	private Long id;
	private String city;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_type")
	private String streetType;
	private Long number;
	private Boolean permanent;
	private Long personid;

	@ManyToOne
	@JoinColumn(name = "personid", insertable = false, updatable = false)
	@JsonBackReference("person_addr")
	private Person person;

	public Address() {
	}

	public Address(Long id, String city, String streetName, String streetType, Long number, Boolean permanent,
			Long personid) {
		super();
		this.id = id;
		this.city = city;
		this.streetName = streetName;
		this.streetType = streetType;
		this.number = number;
		this.permanent = permanent;
		this.personid = personid;
	}

	public Long getId() {
		return id;
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

	public Long getPersonid() {
		return personid;
	}

	public Person getPerson() {
		return person;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPersonid(Long personid) {
		this.personid = personid;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", streetName=" + streetName + ", streetType=" + streetType
				+ ", number=" + number + ", permanent=" + permanent + ", personid=" + personid + "]";
	}
}
