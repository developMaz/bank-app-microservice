package com.bank.credit.controller;

import com.bank.credit.domain.CreditDTO;
import com.bank.credit.domain.CreditItem;
import com.bank.credit.numberGenerator.Generator;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CreditComponentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CreditController creditController;

	@Autowired
	Generator generator;

	private int creditID;
	private List<CreditItem> creditItemList;

	private void setCreditNumber(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO, int creditID) {
		productDTO.setCreditID(creditID);
		customerDTO.setCreditID(creditID);
		creditDTO.setCreditID(creditID);
	};

	@GetMapping("CreateCredit")
	public int createCredit(@PathVariable CustomerDTO customerDTO,
	                        @PathVariable ProductDTO productDTO,
	                        @PathVariable CreditDTO creditDTO) {

		// Set new credit number
		int creditNumber = generator.generateCreditNumber();

		//adding creditNumber to all elements
		setCreditNumber(customerDTO, productDTO, creditDTO, creditNumber);

		// Creating product
		createProduct(productDTO);

		// Creating consumer
		createCustomer(customerDTO);

		// Saving credit data
		creditController.saveCredit(creditDTO);

		//TODO check if everthing is correct
//		creditService.checkCredit(creditNumber);

		return creditNumber;
	}


	@GetMapping("test")
	public String test(){
		return "test test test";
	}

	@RequestMapping(value = "getCustomer?creditID={id}", method = RequestMethod.GET)
	public CustomerDTO getCustomer(@RequestParam Integer id) {

		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", id);

		ResponseEntity<CustomerDTO> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/customer/getAllCustomer", CustomerDTO.class, id);

		CustomerDTO response = responseEntity.getBody();
		return response;
	}

	@RequestMapping(value = "createCustomer", method = RequestMethod.POST)
	public void createCustomer(@RequestBody CustomerDTO customerDTO) {
		ResponseEntity<CustomerDTO> responseEntity = new RestTemplate().postForEntity(
				"http://localhost:8000/customer/createCustomer", customerDTO, CustomerDTO.class);
	}

	@RequestMapping(value = "createProduct", method = RequestMethod.POST)
	public void createProduct(@RequestBody ProductDTO productDTO) {
		ResponseEntity<ProductDTO> responseEntity = new RestTemplate().postForEntity(
				"http://localhost:8100/product/createProduct", productDTO, ProductDTO.class);
	}

}
