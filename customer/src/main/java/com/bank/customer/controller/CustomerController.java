package com.bank.customer.controller;


import com.bank.customer.domain.CustomerDTO;
import com.bank.customer.exceptions.CustomerNotFoundException;
import com.bank.customer.mapper.CustomerMapper;
import com.bank.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("customer/")
public class CustomerController {


	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerMapper customerMapper;

	@RequestMapping(value = "createCustomer", method = RequestMethod.POST,  consumes = APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO customerDTO) {
		customerService.createCustomer(customerMapper.mapToCustomerDB(customerDTO));
	}

	@RequestMapping(value = "getAllCustomers", method = RequestMethod.GET)
	public List<CustomerDTO> getAllCustomers() {
		return customerMapper.mapToCustomerDTOList(customerService.getAllCustomers());
	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.DELETE)
	public void deleteCustomer(@RequestParam final Integer creditID) throws Exception {
		customerService.deleteCustomer(customerService.getCustomerById(creditID).orElseThrow(CustomerNotFoundException::new));
	}

	@RequestMapping(value = "getCustomer", method = RequestMethod.GET)
	public CustomerDTO getCustomerByCreditID(@RequestParam Integer creditID) throws Exception{
		return customerMapper.mapToCustomerDTO(customerService.getCustomerById(creditID).orElseThrow(CustomerNotFoundException::new));
	}

}
