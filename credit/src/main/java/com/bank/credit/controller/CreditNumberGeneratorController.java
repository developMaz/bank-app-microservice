package com.bank.credit.controller;

import com.bank.credit.domain.CreditDTO;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.springframework.stereotype.Controller;

@Controller
public class CreditNumberGeneratorController {

	void setCreditNumber(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO, int creditID) {
		productDTO.setCreditID(creditID);
		customerDTO.setCreditID(creditID);
		creditDTO.setCreditID(creditID);
	};
}
