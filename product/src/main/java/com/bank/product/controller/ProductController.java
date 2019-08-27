package com.bank.product.controller;

import com.bank.product.domain.ProductDTO;
import com.bank.product.exception.ProductNotFoundException;
import com.bank.product.mapper.ProductMapper;
import com.bank.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductMapper productMapper;

	@RequestMapping(value = "createProduct", method = RequestMethod.POST,  consumes = APPLICATION_JSON_VALUE)
	public void createProduct(@RequestBody ProductDTO productDTO) {
		productService.createProduct(productMapper.mapToProductDB(productDTO));
	}

	@RequestMapping(value = "getAllProducts", method = RequestMethod.GET)
	public List<ProductDTO> getAllProducts() {
		return productMapper.mapToProductDTOList(productService.getAllProducts());
	}

	@RequestMapping(value = "deleteProduct", method = RequestMethod.DELETE)
	public void deleteProduct(@RequestParam final int creditID) throws Exception {
		productService.deleteProduct(productService.getProductById(creditID).orElseThrow(ProductNotFoundException::new));
	}

	@RequestMapping(value = "getProduct", method = RequestMethod.GET)
	public ProductDTO getProductByCreditID(int creditID) throws Exception {
		return productMapper.mapToProductDTO(productService.getProductById(creditID).orElseThrow(ProductNotFoundException::new));
	}

}
