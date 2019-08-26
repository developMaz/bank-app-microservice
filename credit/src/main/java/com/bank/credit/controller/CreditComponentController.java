package com.bank.credit.controller;

import com.bank.credit.domain.CreditDTO;
import com.bank.credit.domain.CreditItem;
import com.bank.credit.numberGenerator.Generator;
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
	ServicesController servicesController;
	private int creditID;
	private List<CreditItem> creditItemList;

	@Autowired
	CreditNumberGeneratorController creditNumberGeneratorController;

	@GetMapping("CreateCredit")
	public int createCredit(@PathVariable CustomerDTO customerDTO,
	                        @PathVariable ProductDTO productDTO,
	                        @PathVariable CreditDTO creditDTO) {

		// Set new credit number
		int creditNumber = generator.generateCreditNumber();

		//adding creditNumber to all elements
		creditNumberGeneratorController.setCreditNumber(customerDTO, productDTO, creditDTO, creditNumber);

		// Creating product
		servicesController.createProduct(productDTO);

		// Creating consumer
		servicesController.createCustomer(customerDTO);

		// Saving credit data
		creditController.saveCredit(creditDTO);

		//TODO check if everthing is correct
//		creditService.checkCredit(creditNumber);

		return creditNumber;
	}


}
