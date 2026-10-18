package com.productapp.dto;

import java.util.List;

import com.productapp.model.Brand;
import com.productapp.model.Category;
import com.productapp.model.Feature;
import com.productapp.model.Offer;

public class ProductDto 
{
	private Integer productId;
	private String productName;
	private double price;
	private float ratings;
	private Feature features;
	private List<Offer> offers;
	private Brand brand;
	private List<Category> categories;
	List<String> paymentMode;
	List<String> deliveryType;
}
