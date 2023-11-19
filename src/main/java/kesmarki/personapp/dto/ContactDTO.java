package kesmarki.personapp.dto;

import jakarta.persistence.Column;

public class ContactDTO {
	Long id;
	@Column(unique = true)
	String email;
	String tel;

	public ContactDTO() {
	}

	public ContactDTO(Long id, String email, String tel) {
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "ContactDTO [id=" + id + ", email=" + email + ", tel=" + tel + "]";
	}

}
