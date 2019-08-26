package com.bank.customer.repository;


import com.bank.customer.domain.CustomerDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDB, Integer> {

	@Override
	List<CustomerDB> findAll();

	@Override
	CustomerDB save(CustomerDB customerDB);

	Optional<CustomerDB> getCustomerById(int id);

	@Override
	void delete(CustomerDB customerDB);
}
