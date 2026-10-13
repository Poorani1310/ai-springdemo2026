package com.productapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product 
{
	@Id
	@GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "product_id")
	private Integer id;
	@Column(name = "product_pame", length = 20)
	private String name;	
	@Column(name = "product_price")
	private double cost;
	@Column(name = "product_rating")
	private int rating;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "feature_id")
	private Features features;
	
}
