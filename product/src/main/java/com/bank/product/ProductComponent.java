package com.bank.product;

import com.bank.product.controller.ProductController;
import com.bank.product.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.bank")
public class ProductComponent {

	@Autowired
	ProductController productController;

	public void createProduct(ProductDTO productDTO) {
		productController.createProduct(productDTO);
	}

	public List<ProductDTO> getAllProducts() {
		return productController.getAllProducts();
	}

	public void deleteProduct(final int creditID) throws Exception {
		productController.deleteProduct(creditID);
	}

	public ProductDTO getProductByCreditID(int creditID) throws Exception {
		return productController.getProductByCreditID(creditID);
	}

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "product-application");
		SpringApplication.run(ProductComponent.class, args);
	}

}
