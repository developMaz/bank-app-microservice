package com.bank.credit.service;

import com.bank.credit.controller.ExternalServicesController;
import com.bank.credit.domain.Credit;
import com.bank.credit.domain.CreditInfo;
import com.bank.credit.domain.CreditItem;
import com.bank.customer.domain.CustomerDTO;
import com.bank.customer.exceptions.CustomerNotFoundException;
import com.bank.product.domain.ProductDTO;
import com.bank.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterCreditDataService {

	@Autowired
	ExternalServicesController externalServicesController;

	private CustomerDTO customer = new CustomerDTO();
	private ProductDTO product = new ProductDTO();
	private List<CreditItem> creditsInfoList = new ArrayList<>();

	public List<CreditItem> filter(List<Credit> creditList, List<CustomerDTO> customerList, List<ProductDTO> productList) throws Exception{

		for (Credit credit : creditList) {
			creditsInfoList.add(new CreditItem(new CreditInfo(credit)));
		}

		filterCustomer(creditsInfoList);
		filterProduct(creditsInfoList);

		return creditsInfoList;
	}

	private List<CreditItem> filterCustomer(List<CreditItem> creditsInfoList) throws Exception{
		for (CreditItem credit : creditsInfoList) {
			try {
				customer = externalServicesController.getCustomer(credit.getCreditNumber());
				credit.getCreditInfo().setCustomerDTO(customer);
			} catch (Exception e) {
				throw new CustomerNotFoundException();
			}
		}
		return creditsInfoList;
	}

	private List<CreditItem> filterProduct(List<CreditItem> creditsInfoList) throws Exception{
		for (CreditItem credit : creditsInfoList) {
			try {
				product = externalServicesController.getProduct(credit.getCreditNumber());
				credit.getCreditInfo().setProductDTO(product);
			} catch (Exception e) {
				throw new ProductNotFoundException();
			}
		}
		return creditsInfoList;
	}
}

