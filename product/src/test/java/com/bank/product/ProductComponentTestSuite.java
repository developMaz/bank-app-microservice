package com.bank.product;

import com.bank.product.domain.ProductDTO;
import com.bank.product.exception.ProductNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:product-application.properties")
public class ProductComponentTestSuite {

	@Autowired
	ProductComponent productController;

	@Test
	public void createFindAndDeleteProductTest() throws Exception{
		ProductDTO productDTO = new ProductDTO(12345, "CarCredit",300000);

		productController.createProduct(productDTO);
		List<ProductDTO> list = productController.getAllProducts();
		ProductDTO product = productController.getProductByCreditID(12345);

		Assert.assertEquals(1, list.size());
		Assert.assertEquals(12345, product.getCreditID());

		//clean db
		try {
			productController.deleteProduct(12345);
		} catch (Exception e) {
			new ProductNotFoundException();
		}

	}

	@Test
	public void contextLoads() {
	}

}
