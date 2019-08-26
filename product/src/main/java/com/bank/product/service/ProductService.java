package com.bank.product.service;


import com.bank.product.domain.ProductDB;
import com.bank.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void createProduct(final ProductDB productDB){
		productRepository.save(productDB);
	}

	public List<ProductDB> getAllProducts(){
		return productRepository.findAll();
	}

	public Optional<ProductDB> getProductById(int id){
		return productRepository.getProductById(id);
	}

	public void deleteProduct(ProductDB productDB){
		productRepository.delete(productDB);
	}
}
