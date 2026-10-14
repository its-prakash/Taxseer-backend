package com.taxseer_demo.Cart;

import com.taxseer_demo.Cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/filings")
@RequiredArgsConstructor
@CrossOrigin(
        origins = {"http://localhost:4200", "http://localhost:54288/,"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public Mono<Cart> addToCart(@RequestBody Map<String, Object> payload) {
        return cartService.processFilingToCart(payload);
    }

    @GetMapping("/cart/{filerId}")
    public Flux<Cart> getCartItems(@PathVariable Long filerId) {
        return cartService.getCartItemsForFiler(filerId);
    }
}
