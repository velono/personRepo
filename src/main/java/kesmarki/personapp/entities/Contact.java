package kesmarki.personapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@SequenceGenerator(name = "contact-seq-gen", initialValue = 6, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact-seq-gen")
	private Long id;

	private String email;

	private String tel;

	@OneToOne(mappedBy = "contact")
	@JsonManagedReference("cont_person")
	private Person person;

	public Contact() {
	}

	public Contact(Long id, String email, String tel) {
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

	public Person getPerson() {
		return person;
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

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + ", tel=" + tel + "]";
	}
}
