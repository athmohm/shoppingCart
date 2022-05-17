package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "productId")
	private long productId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_price", nullable = false)
	private double productPrice;

	@Column(name = "product_description")
	private String description;

}