package com.productapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Offer 
{
	@Id
	@GeneratedValue(generator = "offer_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offer_gen", sequenceName = "offer_seq", initialValue = 100, allocationSize = 1)
	private Integer offerId;
	private String offerName; 
	private String offerDesc;
}
