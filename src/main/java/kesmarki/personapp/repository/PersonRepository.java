package kesmarki.personapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kesmarki.personapp.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public List<Person> findByLastNameAndFirstName(String lastName, String firstName);
	public Person getPersonById(Long id);

	@Query(value = "SELECT a.person FROM Address a WHERE a.city =:city")
	public List<Person> findByCity(@Param(value = "city")String city);

}
