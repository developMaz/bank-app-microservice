package com.bank.customer;

import com.bank.customer.controller.CustomerController;
import com.bank.customer.domain.CustomerDTO;
import com.bank.customer.exceptions.CustomerNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:customer-application.properties")
public class CustomerComponentTestSuite {

	@Autowired
	CustomerComponent customerComponent;

	@Autowired
	CustomerController customerController;

	@Test
	public void createFindAndDeleteCustomerTest() throws Exception{
		CustomerDTO customerDTO = new CustomerDTO(12345, "John", "Doe", "12345678910");

		customerComponent.createCustomer(customerDTO);
		List<CustomerDTO> list = customerComponent.getAllCustomers();
		CustomerDTO customer = customerComponent.getCustomerByCreditID(12345);

		Assert.assertEquals(1, list.size());
		Assert.assertEquals("John", customer.getFirstName());

		//clean db
		try {
			customerComponent.deleteCustomer(12345);
		} catch (Exception e) {
			new CustomerNotFoundException();
		}

	}

	@Test
	public void contextLoads() {
	}
}
