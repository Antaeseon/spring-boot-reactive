package com.ts.springboot.reactive;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CartService {
	private final ItemRepository itemRepository;
	private final CartRepository cartRepository;


	Mono<String> addToCart(String cartId,String id) {
		return this.cartRepository.findById(cartId)
			.defaultIfEmpty(new Cart(cartId))
			.flatMap(cart -> cart.getCartItems().stream()
				.filter(cartItem -> cartItem.getItem()
					.getId().equals(id))
				.findAny()
				.map(cartItem -> {
					cartItem.increment();
					return Mono.just(cart);
				})
				.orElseGet(() -> {
					return this.itemRepository.findById(id)
						.map(item -> new CartItem(item))
						.map(cartItem -> {
							cart.getCartItems().add(cartItem);
							return cart;
						});
				}))
			.flatMap(cart -> this.cartRepository.save(cart))
			.thenReturn("redirect:/");
	}


}
