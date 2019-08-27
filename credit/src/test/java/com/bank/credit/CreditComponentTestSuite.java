package com.bank.credit;

import com.bank.credit.controller.CreditController;
import com.bank.credit.controller.ExternalServicesController;
import com.bank.credit.domain.Credit;
import com.bank.credit.domain.CreditInfo;
import com.bank.credit.domain.CreditItem;
import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:credit-application.properties")
public class CreditComponentTestSuite {

	@Autowired
	CreditComponent creditComponent;

	@Autowired
	CreditController creditController;

	@Autowired
	ExternalServicesController externalServicesController;


	@Test
	public void createCreditTest() throws Exception {

		//Given
		CustomerDTO customerDTO = new CustomerDTO("John", "Doe", "80122485236");
		ProductDTO productDTO = new ProductDTO("Super Credit", 100000);
		Credit credit = new Credit("Car Credit");

		//When
		int creditNumber = creditComponent.createCredit(customerDTO, productDTO, credit);
		List<Credit> allCredits = creditController.getAllCredits();
		List<ProductDTO> allProducts = externalServicesController.getAllProducts();
		List<CustomerDTO> allCustomers = externalServicesController.getAllCustomers();

		//Then
		Assert.assertNotNull(allCredits);
		Assert.assertNotNull(allProducts);
		Assert.assertNotNull(allCustomers);
		Assert.assertEquals(creditNumber, allCredits.get(0).getCreditID());



	}

	@Test
	public void getCreditsTest() throws Exception{

	//Given
	CustomerDTO customerDTO1 = new CustomerDTO(12345, "John", "Doe", "12345678910");
	CustomerDTO customerDTO2 = new CustomerDTO(56478, "Mary", "Doe", "23456789101");
	CustomerDTO customerDTO3 = new CustomerDTO(10112, "Albert", "Kettle", "34567891012");
	CustomerDTO customerDTO4 = new CustomerDTO(13145, "Steven", "Fry", "45678910123");
	externalServicesController.createCustomer(customerDTO1);
	externalServicesController.createCustomer(customerDTO2);
	externalServicesController.createCustomer(customerDTO3);
	externalServicesController.createCustomer(customerDTO4);

	ProductDTO productDTO1 = new ProductDTO(12345, "CarCredit1", 100000);
	ProductDTO productDTO2 = new ProductDTO(56478, "CarCredit2", 200000);
	ProductDTO productDTO3 = new ProductDTO(10112, "CarCredit3", 300000);
	externalServicesController.createProduct(productDTO1);
	externalServicesController.createProduct(productDTO2);
	externalServicesController.createProduct(productDTO3);

	Credit creditDTO1 = new Credit(12345, "CarCredit1");
	Credit creditDTO2 = new Credit(56478, "CarCredit2");
	creditController.saveCredit(creditDTO1);
	creditController.saveCredit(creditDTO2);

	//When
	List<CustomerDTO> newList = new ArrayList<>();
	List<CreditItem> creditDTOS = new ArrayList<>();
	creditDTOS.add(new CreditItem(new CreditInfo(creditDTO1)));
	creditDTOS.add(new CreditItem(new CreditInfo(creditDTO2)));


	//Then
	List<CreditItem> list = creditComponent.getCredits();
	Assert.assertEquals(2,list.size());

}


	@Test
	public void contextLoads() {
	}

}
