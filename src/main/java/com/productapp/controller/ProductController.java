package com.productapp.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dtos.ProductDto;
import com.productapp.service.IProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/product-api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
	
	private IProductService productService;
	
	// http://localhost:8082/product-api/v1/products (method is post)
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	// http://localhost:8082/product-api/v1/products (method is put)
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
		productService.updateProduct(productDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	// htpp://localhost:8082/product-api/v1/produtcs (method is delete)
	@DeleteMapping("/products/id/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct (productId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
		
	// http://localhost:8082/product-api/v1/products/id/1
	@GetMapping("/products/id/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable int productId) {
		ProductDto productdto = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting products by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(productdto);
	}
	
	// http://localhost:8082/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productdtos = productService.getAllProducts();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting products by Id");
		headers.add("info", "Getting products by Id");		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(productdtos);
	}
	
	// http://localhost:8082/product-api/v1/products/price/1200
	@GetMapping("/products/price/{price}")
	ResponseEntity<List<ProductDto>> getByLesserPrice(@PathVariable double price){
		List<ProductDto> productdtos = productService.getByLesserPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting products less than the price");		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(productdtos);
	}
	
	ResponseEntity<List<ProductDto>> getByBrand(String brand) {
		List<ProductDto> productdtos = productService.getByBrand(brand);		
		return ResponseEntity.ok(productdtos);
	}
	
	// http://localhost:8082/product-api/v1/products/product/name?productname=bottle
	@GetMapping("/product/name")
	ResponseEntity<List<ProductDto>> getByProductNameContains(@RequestParam String productname) {
		List<ProductDto> productDtos = productService.getByProductNameContains(productname);
		return ResponseEntity.ok(productDtos);

	}
	
	// http://localhost:8080/product-api/v1/products/productname/bottle
	@GetMapping("/products/productname/{name}")
	ResponseEntity<List<String>> getByNameHaving(@PathVariable String productName) {
		List<String> productNames = productService.getByNameHaving(productName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all products");
		headers.add("info", "Returning the product list");
		return new ResponseEntity<>(productNames, headers, HttpStatus.OK.value());

	}
}
