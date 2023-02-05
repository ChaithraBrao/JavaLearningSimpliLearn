package com.example.demo;

import javax.persistence.Entity;


import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	private int id;
	private String productname;
	private String description;
	private String category;
	private int price;
	private int quantity;
	private int size;
	
	//private String filePath;
	
	
}
