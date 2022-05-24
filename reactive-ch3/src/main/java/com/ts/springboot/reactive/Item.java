package com.ts.springboot.reactive;

import java.awt.*;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode()
public class Item {

	@Id
	private String id;
	private String name;
	private String description;
	private double price;
	private String distributorRegion;
	private Date releaseDate;
	private int availableUnits;
	private Point location;
	private boolean active;

	public Item() {
	}

	public Item(String name,double price) {
		this.name = name;
		this.price = price;
	}

	public Item(String name,String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}




}
