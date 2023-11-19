package kesmarki.personapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kesmarki.personapp.dto.AddressDTO;
import kesmarki.personapp.dto.AddressDtoMapper;
import kesmarki.personapp.entities.Address;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	private final AddressDtoMapper addressDtoMapper = new AddressDtoMapper();

	// Add new address
	public String addAddress(AddressDTO addressDTO) throws WrongInputException {
		if (isInputNotComplete(addressDTO)) {
			throw new WrongInputException("Please fill in all fields.");
		}
		addressLimitChecker(addressDTO);

		try {
			Address addedAddress = addressRepository.save(addressDtoMapper.toAddress(addressDTO));
			return "Address details added with id: " + addedAddress.getId();
		} catch (DataIntegrityViolationException e) {
			throw new WrongInputException("Email already exists.");
		}
	}

	// Retrieve
	public List<AddressDTO> getAllAddress() {
		List<Address> addressList = addressRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		List<AddressDTO> dtoList = new ArrayList<>();
		for (Address a : addressList) {
			dtoList.add(addressDtoMapper.toDTO(a));
		}
		return dtoList;
	}

	// Update
	public String updateAddress(@Valid AddressDTO addressDTO) throws WrongInputException {
		if (isInputNotComplete(addressDTO)) {
			throw new WrongInputException("Please fill in all fields.");
		}
		addressLimitChecker(addressDTO);

		Address address = addressRepository.findById(addressDTO.getId()).orElseThrow();
		address.setCity(addressDTO.getCity());
		address.setStreetName(addressDTO.getStreetName());
		address.setStreetType(addressDTO.getStreetType());
		address.setNumber(addressDTO.getNumber());
		address.setPermanent(addressDTO.getPermanent());
		address.setPersonid(addressDTO.getPersonid());
		return "Address updated. " + address.getId();
	}

	// Delete
	public void deleteAddressById(Long id) {
		addressRepository.findById(id).orElseThrow();
		addressRepository.deleteById(id);
	}

	// Other methods
	public boolean isInputNotComplete(AddressDTO addressDTO) {
		return (addressDTO.getCity() == null || addressDTO.getStreetType() == null || addressDTO.getStreetName() == null
				|| addressDTO.getNumber() == null || addressDTO.getPersonid() == null);

	}

	public void addressLimitChecker(AddressDTO addressDTO) throws WrongInputException {
		List<Boolean> addressTypesOfPerson = addressRepository.getAddressTypesOfPerson(addressDTO.getPersonid());
		if (addressDTO.getPermanent() && addressTypesOfPerson.contains(true)) {
			throw new WrongInputException("This person already has a permanent address!");
		} else if (!addressDTO.getPermanent() && addressTypesOfPerson.contains(false)) {
			throw new WrongInputException("This person already has a temporary address!");
		}
	}
}
