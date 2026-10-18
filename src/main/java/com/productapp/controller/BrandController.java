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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.BrandDto;
import com.productapp.service.IBrandService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/product-api/brands")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandController 
{
	IBrandService brandService;
	
	@PostMapping("")
	ResponseEntity<Void> addBrand(BrandDto brandDto)
	{
		brandService.addBrand(brandDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}	
	
	@PutMapping("")
	ResponseEntity<Void> updateBrand(BrandDto brandDto)
	{
		brandService.updateBrand(brandDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping("/{brandId}")
	ResponseEntity<Void> deleteBrand(@PathVariable Integer brandId)
	{
		brandService.deleteBrand(brandId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("")
	ResponseEntity<List<BrandDto>> getAllBrand()
	{
		List<BrandDto> brandDtos = brandService.getAll();
		HttpHeaders header = new HttpHeaders();
		header.add("Desc", "Getting all the brands");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(header).body(brandDtos);
	}
	
	@GetMapping("/brands/{brandId}")
	ResponseEntity<BrandDto> getBrandById(@PathVariable Integer brandId)
	{
		BrandDto brandDto = brandService.getById(brandId);
		HttpHeaders header = new HttpHeaders();
		header.add("Desc", "Getting the brand by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(header).body(brandDto);
	}	

}
