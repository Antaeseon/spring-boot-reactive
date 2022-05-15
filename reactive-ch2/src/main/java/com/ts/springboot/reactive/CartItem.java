package com.ts.springboot.reactive;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CartItem {

	private Item item;
	private int quantity;

	public CartItem() {
	}

	public CartItem(Item item) {
		this.item = item;
		this.quantity = 1;
	}

}
