package com.bank.credit;

import com.bank.credit.controller.CreditController;
import com.bank.credit.domain.Credit;
import com.bank.credit.exception.CreditNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:credit-application.properties")
public class CreditServiceTestSuite {

	@Autowired
	private CreditController creditController;

	@Test
	public void createFindAndDeleteProductTest() throws Exception{
		Credit credit = new Credit("Credit");
		credit.setCreditID(12345);

		creditController.saveCredit(credit);
		List<Credit> list = creditController.getAllCredits();
		Credit product = creditController.getCreditByCreditID(12345);

		Assert.assertEquals(1, list.size());
		Assert.assertEquals(12345, product.getCreditID());

		//clean db
		try {
			creditController.deleteCredit(12345);
		} catch (Exception e) {
			new CreditNotFoundException();
		}
	}

	@Test
	public void contextLoads() {
	}
}
