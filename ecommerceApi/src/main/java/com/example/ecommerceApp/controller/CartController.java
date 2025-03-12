package com.example.ecommerceApp.controller;


import com.example.ecommerceApp.dto.CartDto;
import com.example.ecommerceApp.dto.CartRequestDto;
import com.example.ecommerceApp.entity.Cart;
import com.example.ecommerceApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartDto> getAll(){
        return cartService.getAll();
    }

    @GetMapping("/{userId}")
    public List<CartDto> getByUserId(@PathVariable Integer userId) {
        return cartService.getByUserId(userId);
    }

    @PostMapping
    public CartDto addCart(@RequestBody CartRequestDto cartRequestDto){
        return cartService.addCart(cartRequestDto);
    }

    @PutMapping
    public ResponseEntity<String> updateProductQuantity(@RequestBody CartRequestDto cartRequestDto){
        cartService.updateQuantity(cartRequestDto);

        return ResponseEntity.ok("Cart with userId" + cartRequestDto.getUserId() +
                " And Product id "+ cartRequestDto.getProductId()+" updated successfully 👍");
    }
}
