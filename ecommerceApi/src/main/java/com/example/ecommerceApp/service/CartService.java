package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dto.*;
import com.example.ecommerceApp.entity.Cart;
import com.example.ecommerceApp.entity.CartId;
import com.example.ecommerceApp.entity.Product;
import com.example.ecommerceApp.entity.User;
import com.example.ecommerceApp.mapper.CartIdMapper;
import com.example.ecommerceApp.mapper.CartMapper;
import com.example.ecommerceApp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartIdMapper cartIdMapper;

    public List<CartDto> getAll(){
        List<Cart> carts = cartRepository.findAll();
        return carts.stream()
                .map(cartMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CartDto> getByUserId(Integer id){
        List<Cart> carts =  cartRepository.findByUserId(id);
        return carts.stream()
                .map(cartMapper::toDto)
                .collect(Collectors.toList());
    }

    public CartDto addCart(CartRequestDto cartRequestDto){
        UserDto userDto = userService.getById(cartRequestDto.getUserId());
        ProductDto productDto = productService.getProductByID(cartRequestDto.getProductId());
        CartIdDto cartIdDto = CartIdDto.builder()
                .productId(cartRequestDto.getProductId())   
                .userId(cartRequestDto.getUserId())
                .build();

        Optional<Cart> existingCart = cartRepository.findByCartId(cartIdMapper.toEntity(cartIdDto));

        if(existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setQuantity(cart.getQuantity()+cartRequestDto.getQuantity());
            
            return cartMapper.toDto(cartRepository.save(cart));

        }else{
            CartDto cartDto = CartDto.builder()
                .cartId(CartIdDto.builder()
                        .productId(productDto.getId())
                        .userId(userDto.getId())
                        .build())
                .userDto(userDto)
                .productDto(productDto)
                .quantity(cartRequestDto.getQuantity())
                .isDeleted(0)
                .build();

        Cart cart = cartRepository.save(cartMapper.toEntity(cartDto));
        return cartMapper.toDto(cart);
        }
        
    }

    public void updateQuantity(CartRequestDto cartRequestDto){
        CartId cartId = CartId.builder()
                .userId(cartRequestDto.getUserId())
                .productId(cartRequestDto.getProductId())
                .build();

        cartRepository.updateCartQuantity(cartId,cartRequestDto.getQuantity());
    }
}
