package kesmarki.personapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kesmarki.personapp.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query(value = "SELECT a.permanent FROM Address a WHERE a.personid=:personId")
	public List<Boolean> getAddressTypesOfPerson(@Param(value = "personId") Long personId);
}
