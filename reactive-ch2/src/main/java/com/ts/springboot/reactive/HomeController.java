package com.ts.springboot.reactive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final ItemRepository itemRepository;
	private final CartRepository cartRepository;
	private final CartService cartService;

	@GetMapping
	Mono<Rendering> home() {
		return Mono.just(Rendering.view("home")
			.modelAttribute("items", this.itemRepository.findAll())
			.modelAttribute("cart", this.cartRepository.findById("My Cart")
				.defaultIfEmpty(new Cart("My Cart")))
			.build());
	}

	@PostMapping("/add/{id}")
	Mono<String> addToCart(@PathVariable String id) {
		return this.cartService.addToCart("My Cart", id)
			.thenReturn("redirect:/");
		// return this.cartRepository.findById("My Cart")
		// 	.defaultIfEmpty(new Cart("My Cart"))
		// 	.flatMap(cart -> cart.getCartItems().stream()
		// 		.filter(cartItem -> cartItem.getItem()
		// 			.getId().equals(id))
		// 		.findAny()
		// 		.map(cartItem -> {
		// 			cartItem.increment();
		// 			return Mono.just(cart);
		// 		})
		// 		.orElseGet(() -> {
		// 			return this.itemRepository.findById(id)
		// 				.map(item -> new CartItem(item))
		// 				.map(cartItem -> {
		// 					cart.getCartItems().add(cartItem);
		// 					return cart;
		// 				});
		// 		}))
		// 	.flatMap(cart -> this.cartRepository.save(cart))
		// 	.thenReturn("redirect:/");
	}

}
