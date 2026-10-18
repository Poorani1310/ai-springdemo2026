package com.productapp.service;

import java.util.List;

import com.productapp.dto.BrandDto;
import com.productapp.model.Brand;

public interface IBrandService 
{
	void addBrand(BrandDto brandDto);
	
	void updateBrand(BrandDto brandDto);
	
	void deleteBrand(Integer brandId);
	
	BrandDto getById(Integer brandId);
	
	List<BrandDto> getAll();
}
