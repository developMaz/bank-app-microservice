package com.bank.customer.mapper;

import com.bank.customer.domain.CustomerDB;
import com.bank.customer.domain.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

	public CustomerDB mapToCustomerDB(final CustomerDTO customerDTO) {
		return new CustomerDB(
				customerDTO.getCreditID(),
				customerDTO.getFirstName(),
				customerDTO.getSecondName(),
				customerDTO.getPesel());
	}

	public CustomerDTO mapToCustomerDTO(final CustomerDB customerDB) {
		return new CustomerDTO(
				customerDB.getId(),
				customerDB.getFirstName(),
				customerDB.getSecondName(),
				customerDB.getPesel());
	}

	public List<CustomerDTO> mapToCustomerDTOList(final List<CustomerDB> customerDBList) {
		return customerDBList.stream()
				.map(c -> new CustomerDTO(c.getId(), c.getFirstName(), c.getSecondName(), c.getPesel()))
				.collect(Collectors.toList());
	}
}
