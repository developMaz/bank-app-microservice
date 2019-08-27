package com.bank.credit.controller;

import com.bank.credit.domain.Credit;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.springframework.stereotype.Controller;

@Controller
public class CreditNumberGeneratorController {

	void setCreditNumber(CustomerDTO customerDTO, ProductDTO productDTO, Credit credit, int creditID) {
		productDTO.setCreditID(creditID);
		customerDTO.setCreditID(creditID);
		credit.setCreditID(creditID);
	};
}
