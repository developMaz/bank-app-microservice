package com.bank.customer.service;

import com.bank.customer.domain.CustomerDB;
import com.bank.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


	@Autowired
	CustomerRepository customerRepository;

	public List<CustomerDB> getAllCustomers(){
		return customerRepository.findAll();
	}

	public CustomerDB createCustomer(final CustomerDB customerDB){
		return customerRepository.save(customerDB);
	}

	public Optional<CustomerDB> getCustomerById(int creditID){
		return customerRepository.getCustomerById(creditID);
	}

	public void deleteCustomer(CustomerDB customerDB){
		customerRepository.delete(customerDB);
	}
}
