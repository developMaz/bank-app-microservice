package com.bank.credit.controller;

import com.bank.credit.domain.Credit;
import com.bank.credit.domain.CreditItem;
import com.bank.credit.numberGenerator.Generator;
import com.bank.credit.service.FilterCreditDataService;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CreditComponentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CreditController creditController;

	@Autowired
	Generator generator;

	@Autowired
	ExternalServicesController externalServicesController;

	@Autowired
	FilterCreditDataService filterCreditData;

	private int creditID;
	private List<CreditItem> creditItemList;

	@Autowired
	CreditNumberGeneratorController creditNumberGeneratorController;

	@GetMapping("CreateCredit")
	public int createCredit(@PathVariable CustomerDTO customerDTO,
	                        @PathVariable ProductDTO productDTO,
	                        @PathVariable Credit credit) {

		// Set new credit number
		int creditNumber = generator.generateCreditNumber();

		//adding creditNumber to all elements
		creditNumberGeneratorController.setCreditNumber(customerDTO, productDTO, credit, creditNumber);

		// Creating product
		externalServicesController.createProduct(productDTO);

		// Creating consumer
		externalServicesController.createCustomer(customerDTO);

		// Saving credit data
		creditController.saveCredit(credit);

		//TODO check if everthing is correct
//		creditService.checkCredit(creditNumber);

		return creditNumber;
	}

	public List<CreditItem> getCredits() throws Exception {

		// Getting all credits
		List<Credit> creditList = creditController.getAllCredits();

		// Getting all customers
		List<CustomerDTO> customerList = externalServicesController.getAllCustomers();

		// Getting all products
		List<ProductDTO> productList = externalServicesController.getAllProducts();

		// filter all data
		List<CreditItem> creditsInfoList = filterCreditData.filter(creditList, customerList, productList);

		return creditsInfoList;
	}


}
