package com.productapp.service;

import java.util.List;

import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;

public interface IProductService 
{
	void addProduct(ProductDto productdto);
	void updateProduct(ProductDto productdto);
	void deleteProduct(int productId);
	ProductDto getById(int productId) throws ProductNotFoundException;
	
	List<ProductDto> getAllProducts();
	List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException;
	List<ProductDto> getByBrand(String brand) throws ProductNotFoundException;
	List<String> getByNameHaving(String name);
	List<ProductDto> getByProductNameContains(String productname);
}
