package com.productapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto 
{	
		private Integer id;
		private String name;	
		private double cost;
		private int rating;
		private FeaturesDto features;
}
