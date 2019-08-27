package com.bank.credit.domain;

import com.bank.customer.domain.CustomerDTO;
import com.bank.product.domain.ProductDTO;

public class CreditInfo {

	private CustomerDTO customerDTO;
	private ProductDTO productDTO;
	private Credit credit;

	public CreditInfo(CustomerDTO customerDTO, Credit credit) {
		this.customerDTO = customerDTO;
		this.credit = credit;
	}

	public CreditInfo(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public CreditInfo(Credit credit) {
		this.credit = credit;
	}

	public CreditInfo(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public CreditInfo(){
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}
}
