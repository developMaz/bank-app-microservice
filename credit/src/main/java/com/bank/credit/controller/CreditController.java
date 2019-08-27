package com.bank.credit.controller;

import com.bank.credit.domain.Credit;
import com.bank.credit.exception.CreditNotFoundException;
import com.bank.credit.mapper.CreditMapper;
import com.bank.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class CreditController {

	@Autowired
	private CreditService creditService;

	@Autowired
	private CreditMapper creditMapper;

	@Autowired
	ExternalServicesController externalServicesController;

	@RequestMapping(value = "createCustomer", method = RequestMethod.POST,  consumes = APPLICATION_JSON_VALUE)
	public void saveCredit(@RequestBody Credit credit) {
		creditService.saveCredit(creditMapper.mapToCreditDB(credit));
	}

	public List<Credit> getAllCredits() {
		return creditMapper.mapToCreditDTOList(creditService.getAllCredits());
	}
	public void deleteCredit(final int creditID) throws Exception {
		creditService.deleteCredit(creditService.getCreditById(creditID).orElseThrow(CreditNotFoundException::new));
	}

	public Credit getCreditByCreditID(int creditID) throws Exception{
		return creditMapper.mapToCredit(creditService.getCreditById(creditID).orElseThrow(CreditNotFoundException::new));
	}

	public void deleteWholeCreditInfo(final int creditID) throws Exception{

		deleteCredit(creditID);
		externalServicesController.deleteCustomer(creditID);
		externalServicesController.deleteProduct(creditID);

	}

}
