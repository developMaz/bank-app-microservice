package com.bank.product.mapper;


import com.bank.product.domain.ProductDB;
import com.bank.product.domain.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

	public ProductDB mapToProductDB(final ProductDTO productDTO) {
		return new ProductDB(
				productDTO.getCreditID(),
				productDTO.getProductName(),
				productDTO.getProductValue());
	}

	public ProductDTO mapToProductDTO(final ProductDB productDB) {
		return new ProductDTO(
				productDB.getId(),
				productDB.getProductName(),
				productDB.getValue());
	}

	public List<ProductDTO> mapToProductDTOList(final List<ProductDB> productDBList) {
		return productDBList.stream()
				.map(p -> new ProductDTO(p.getId(), p.getProductName(), p.getValue()))
				.collect(Collectors.toList());
	}
}
