package com.productapp.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class Product 
{
	@Id
	@GeneratedValue(generator = "prod_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "prod_gen", sequenceName = "prod_seq", initialValue = 1001, allocationSize = 1 )
	private Integer productId;
	@Column(length = 20)
	private String productName;
	private double price;
	private float ratings;
	
	@OneToOne
//	gives the column name feature_id and will be added to the product table 
	@JoinColumn(name = "feature_id")
	private Feature features;
	
	@OneToMany
//	creates the column in the offers table with the column name product_id
	@JoinColumn(name = "product_id")
	private List<Offer> offers;
	
	@ManyToOne
//	the column brand_id will be added to the table product table
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToMany
//	to have only one table created in the name of product_category with 2 columns spec.
	@JoinTable(name = "product_category", 
			   joinColumns = @JoinColumn(name = "product_id"),
			   inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories;
	
	@ElementCollection
	@CollectionTable(name = "payment_mode", 
					joinColumns = @JoinColumn(name = "product_id"))
	List<String> paymentMode;
	
	@ElementCollection
	@CollectionTable(name = "delivery_type", 
					joinColumns = @JoinColumn(name = "product_id"))
	List<String> deliveryType;
	
}
