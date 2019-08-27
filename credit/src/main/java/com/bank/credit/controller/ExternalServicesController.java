package com.bank.credit.controller;

import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ExternalServicesController {

	@RequestMapping(value = "getCustomer?creditID={id}", method = RequestMethod.GET)
	public CustomerDTO getCustomer(@PathVariable Integer creditID) {

		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", creditID);

		ResponseEntity<CustomerDTO> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/customer/getCustomer", CustomerDTO.class, creditID);

		CustomerDTO response = responseEntity.getBody();
		return response;
	}

	@RequestMapping(value = "getProduct?creditID={id}", method = RequestMethod.GET)
	public ProductDTO getProduct(@RequestParam Integer id) {

		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", id);

		ResponseEntity<ProductDTO> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8100/product/getProduct", ProductDTO.class, id);

		ProductDTO response = responseEntity.getBody();
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


	@RequestMapping(value = "getAllCustomers", method = RequestMethod.GET)
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> list = new ArrayList<>();

		ResponseEntity<List<CustomerDTO>> responseEntity = new RestTemplate().exchange(
				"http://localhost:8000/customer/getAllCustomers",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<CustomerDTO>>(){});

		List<CustomerDTO> customerDTOList = responseEntity.getBody();

		return customerDTOList;
	}

	@RequestMapping(value = "getAllProducts", method = RequestMethod.GET)
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> list = new ArrayList<>();

		ResponseEntity<List<ProductDTO>> responseEntity = new RestTemplate().exchange(
				"http://localhost:8100/product/getAllProducts",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ProductDTO>>(){});

		List<ProductDTO> productDTOList = responseEntity.getBody();

		return productDTOList;
	}

	@RequestMapping(value = "deleteCustomer?creditID={id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@RequestParam Integer id) {

		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", id);

		ResponseEntity responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/customer/deleteCustomer", Integer.class, id);
	}

	@RequestMapping(value = "deleteProduct?creditID={id}", method = RequestMethod.DELETE)
	public void deleteProduct(@RequestParam Integer id) {

		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", id);

		ResponseEntity responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8100/product/deleteProduct", Integer.class, id);
	}

}
