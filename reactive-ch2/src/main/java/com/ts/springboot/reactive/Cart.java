package com.ts.springboot.reactive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Cart {
	@Id
	private String id;
	private List<CartItem> cartItems;

	public Cart() {
	}

	public Cart(String id) {
		this.id = id;
		this.cartItems = new ArrayList<>();
	}

	public Cart(String id, List<CartItem> cartItems) {
		this.id = id;
		this.cartItems = cartItems;
	}


}
