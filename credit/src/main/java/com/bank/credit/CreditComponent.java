package com.bank.credit;

import com.bank.credit.controller.CreditComponentController;
import com.bank.credit.domain.CreditDTO;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = "com.bank")
@EnableFeignClients("com.bank.credit.config")
@EnableDiscoveryClient
@RequestMapping("bank/")
public class CreditComponent {

	@Autowired
	CreditComponentController creditComponentController;

	public int createCredit(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO) {
		return creditComponentController.createCredit(customerDTO, productDTO, creditDTO);
	}

//	public List<CreditItem> getCredits() throws Exception{
//		return creditController.getCredits();
//	}


	public static void main(String[] args) {
		System.setProperty("spring.config.name", "credit-application");
		SpringApplication.run(CreditComponent.class, args);
	}

}
