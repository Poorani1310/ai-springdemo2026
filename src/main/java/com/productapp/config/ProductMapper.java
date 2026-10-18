package com.productapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.productapp.dto.BrandDto;
import com.productapp.dto.CategoryDto;
import com.productapp.dto.ProductDto;
import com.productapp.model.Brand;
import com.productapp.model.Category;
import com.productapp.model.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper 
{
	private final ModelMapper mapper; 
	
	public BrandDto toBrandDto(Brand brand)
	{
		return mapper.map(brand, BrandDto.class);
	}
	
	public Brand toBrandEntity(BrandDto brandDto)
	{
		return mapper.map(brandDto, Brand.class);
	}
	
	public CategoryDto toCategoryDto(Category category)
	{
		return mapper.map(category, CategoryDto.class);
	}
	
	public Category toCategoryEntity(CategoryDto categoryDto)
	{
		return mapper.map(categoryDto, Category.class);
	}
	
	public ProductDto toProductDto(Product product)
	{
		return mapper.map(product, ProductDto.class);
	}
	
	public Product toCategoryEntity(ProductDto productDto)
	{
		return mapper.map(productDto, Product.class);
	}
}
