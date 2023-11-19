package kesmarki.personapp.dto;

public class AddressDTO {
	private Long id;
	private String city;
	private String streetName;
	private String streetType;
	private Long number;
	private Boolean permanent;
	private Long personid;

	public AddressDTO() {
	}

	public AddressDTO(Long id, String city, String streetName, String streetType, Long number, Boolean permanent,
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

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", city=" + city + ", streetName=" + streetName + ", streetType=" + streetType
				+ ", number=" + number + ", permanent=" + permanent + ", personid=" + personid + "]";
	}

}
