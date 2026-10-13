package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByCostLessThan(double price);
	
//	List<Product> findByNameContains(String name);
	
//	List<Product> findByNameContainingIgnoreCase(String name);
//	@Query("select p from Product p where p.name like ?1")
	List<Product> findByNameContainingIgnoreCase(String name);

	@Query("select p from Product p where p.name like ?1")
	List<Product> findByName(String productName);

}
