package com.productapp.model;

import jakarta.persistence.Column;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Features {
	
	@Id
	@GeneratedValue(generator = "feature_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "feature_gen", sequenceName = "feature_seq", initialValue = 1, allocationSize = 1)
	private Integer featureId;
	@Column(length = 20)
	private String colour;
	private String material;
	private String description;

}
