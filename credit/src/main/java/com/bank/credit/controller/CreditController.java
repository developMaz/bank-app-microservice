package com.bank.credit.controller;

import com.bank.credit.domain.CreditDTO;
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

//	public List<CreditItem> generateAndSetCreditNumber(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO){
//		int creditNumber = generator.generateCreditNumber();
//		CreditInfo creditInfo = new CreditInfo();
//		CreditItem creditItem = new CreditItem(new CreditInfo);
//		creditItemList.add(new CreditItem(n))productDTO.setCreditID(creditID);
//		customerDTO.setCreditID(creditID);
//		creditDTO.setCreditID(creditID);
//	}

	@RequestMapping(value = "createCustomer", method = RequestMethod.POST,  consumes = APPLICATION_JSON_VALUE)
	public void saveCredit(@RequestBody CreditDTO creditDTO) {
		creditService.saveCredit(creditMapper.mapToCreditDB(creditDTO));
	}

	public List<CreditDTO> getAllCredits() {
		return creditMapper.mapToCreditDTOList(creditService.getAllCredits());
	}
	public void deleteCredit(final int creditID) throws Exception {
		creditService.deleteCredit(creditService.getCreditById(creditID).orElseThrow(CreditNotFoundException::new));
	}

	public CreditDTO getCreditByCreditID(int creditID) throws Exception{
		return creditMapper.mapToCreditDTO(creditService.getCreditById(creditID).orElseThrow(CreditNotFoundException::new));
	}


}
