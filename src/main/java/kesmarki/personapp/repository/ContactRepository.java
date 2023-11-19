package kesmarki.personapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kesmarki.personapp.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
