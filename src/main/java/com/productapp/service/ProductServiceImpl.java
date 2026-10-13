package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productrepository;

	private final ModelMapper mapper;

	@Override
	public void addProduct(ProductDto productdto) {
		Product product = mapper.map(productdto, Product.class);
		productrepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productdto) {
		Product product = mapper.map(productdto, Product.class);
		productrepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productrepository.deleteById(productId);
	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Product product = productrepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product with Id not found"));
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productrepository.findAll();
		return products.stream()
				       .map((product) -> mapper.map(product, ProductDto.class))
				       .toList();
	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		// convert list of product to list of dtos
		List<Product> products = productrepository.findByCostLessThan(price);
		return products.stream()
				       .map(product -> mapper.map(product, ProductDto.class))
					   .sorted(Comparator.comparing(ProductDto::getName))
					   .toList();
	}

	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getByNameHaving(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByProductNameContains(String productname) {
		// using custom query
//		String str = "%" + productname + "%";
//		List<Product> products = productrepository.findByNameContainingIgnoreCase("%" + productname + "%");
		List<Product> products = productrepository.findByNameContainingIgnoreCase(productname);
//		System.out.println("Search value: " + str);
//		System.out.println("Products found: " + products.size());
//		System.out.println(products);

		return products.stream()
				       .map(product -> mapper.map(product, ProductDto.class))
					   .sorted(Comparator.comparing(ProductDto::getName))
					   .toList();
	}

}
