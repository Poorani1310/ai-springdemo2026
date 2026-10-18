package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.config.ProductMapper;
import com.productapp.dto.BrandDto;
import com.productapp.model.Brand;
import com.productapp.repository.IBrandRepository;

@Service
public class brandServiceImpl implements IBrandService {

	IBrandRepository brandRepository;
	ProductMapper mapper;
	
	@Override
	public void addBrand(BrandDto brandDto) 
	{
		Brand brand = mapper.toBrandEntity(brandDto);
		brandRepository.save(brand);
	}

	@Override
	public void updateBrand(BrandDto brandDto) 
	{
		Brand brand = mapper.toBrandEntity(brandDto);
		brandRepository.save(brand);
	}

	@Override
	public void deleteBrand(Integer brandId) 
	{
		brandRepository.deleteById(brandId);
	}

	@Override
	public BrandDto getById(Integer brandId) 
	{
		Brand brand = brandRepository.findById(brandId)
									 .orElseThrow(()->new RuntimeException("Brand not found"));
		return mapper.toBrandDto(brand);
	}

	@Override
	public List<BrandDto> getAll() 
	{
		List<Brand> brands = brandRepository.findAll();
		return brands.stream().map(brand->mapper.toBrandDto(brand)).toList();
	}

}
