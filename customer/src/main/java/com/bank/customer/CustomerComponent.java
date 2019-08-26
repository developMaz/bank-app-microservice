package com.bank.customer;

import com.bank.customer.controller.CustomerController;
import com.bank.customer.domain.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerComponent{

	@Autowired
	CustomerController customerController;

	public void createCustomer(CustomerDTO customerDTO) {
		customerController.createCustomer(customerDTO);
	}

	public List<CustomerDTO> getAllCustomers() {
		return customerController.getAllCustomers();
	}
	public void deleteCustomer(final int creditID) throws Exception {
		customerController.deleteCustomer(creditID);
	}

	public CustomerDTO getCustomerByCreditID(int creditID) throws Exception{
		return customerController.getCustomerByCreditID(creditID);
	}


	public static void main(String[] args) {
		System.setProperty("spring.config.name", "customer-application");
		SpringApplication.run(CustomerComponent.class, args);
	}

}
