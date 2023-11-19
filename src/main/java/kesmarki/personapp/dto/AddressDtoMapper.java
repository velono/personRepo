package kesmarki.personapp.dto;

import kesmarki.personapp.entities.Address;

public class AddressDtoMapper {

	public Address toAddress(AddressDTO addressDTO) {
		Address address = new Address();
		address.setCity(addressDTO.getCity());
		address.setStreetName(addressDTO.getStreetName());
		address.setStreetType(addressDTO.getStreetType());
		address.setNumber(addressDTO.getNumber());
		address.setPermanent(addressDTO.getPermanent());
		address.setPersonid(addressDTO.getPersonid());
		return address;
	}

	public AddressDTO toDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(address.getId());
		addressDTO.setCity(address.getCity());
		addressDTO.setStreetName(address.getStreetName());
		addressDTO.setStreetType(address.getStreetType());
		addressDTO.setNumber(address.getNumber());
		addressDTO.setPermanent(address.getPermanent());
		addressDTO.setPersonid(address.getPersonid());
		return addressDTO;
	}
}
