package com.example.ecommerceApp.controller;


import com.example.ecommerceApp.dto.CartDto;
import com.example.ecommerceApp.dto.CartRequestDto;
import com.example.ecommerceApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<CartDto> cartDtos = cartService.getAll();

        if(cartDtos.isEmpty()){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "No Cart found");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else {
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", cartDtos); 
            response.put("Message", "get all products successful");

            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable Integer userId) {
        List<CartDto> cartDtos = cartService.getByUserId(userId);

        if(cartDtos.isEmpty()){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "No Cart found");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else {
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", cartDtos); 
            response.put("Message", "get all products  successful");

            return ResponseEntity.ok(response);
        }
    }

    
    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody CartRequestDto cartRequestDto){
        CartDto cart = cartService.addCart(cartRequestDto);

        if (cart.equals(null)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "Can't add cart");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", cart); 
            response.put("Message", "add new cart successful");

            return ResponseEntity.ok(response);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProductQuantity(@RequestBody CartRequestDto cartRequestDto){
        cartService.updateQuantity(cartRequestDto);

        return ResponseEntity.ok("Cart with userId" + cartRequestDto.getUserId() +
                " And Product id "+ cartRequestDto.getProductId()+" updated successfully 👍");
    }
}
