package com.bank.credit.controller;

import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServicesController {

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
