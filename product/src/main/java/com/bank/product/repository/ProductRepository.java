package com.bank.product.repository;


import com.bank.product.domain.ProductDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductDB, Integer> {

	@Override
	List<ProductDB> findAll();

	@Override
	ProductDB save(ProductDB product);

	Optional<ProductDB> getProductById(int id);

	@Override
	void delete(ProductDB product);
}
