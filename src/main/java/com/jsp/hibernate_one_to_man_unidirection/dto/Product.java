package com.jsp.hibernate_one_to_man_unidirection.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	private int product_id;
	private String product_name;
	private double product_price;
	

}
