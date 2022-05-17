package com.capg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@Column(name = "order_details_id")
	private Long orderDetailsId;
	private Long productId;
	private String productName;
	private Double productPrice;
	private Long quantity;
	private Double totalPrice;
	private Long vendorId;
	private String status;
	private String comments;
	
	@OneToMany
	@JoinColumn(name = "order_id")
	List<Order> order = new ArrayList<>();

}