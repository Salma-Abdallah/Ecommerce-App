package com.example.ecommerceApp.mapper;

import com.example.ecommerceApp.dto.CartDto;
import com.example.ecommerceApp.dto.CartIdDto;
import com.example.ecommerceApp.entity.Cart;
import com.example.ecommerceApp.entity.CartId;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T10:55:12+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Cart toEntity(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart.CartBuilder cart = Cart.builder();

        cart.user( userMapper.toEntity( cartDto.getUserDto() ) );
        cart.product( productMapper.toEntity( cartDto.getProductDto() ) );
        cart.cartId( cartIdDtoToCartId( cartDto.getCartId() ) );
        cart.quantity( cartDto.getQuantity() );
        cart.isDeleted( cartDto.getIsDeleted() );

        return cart.build();
    }

    @Override
    public CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto.CartDtoBuilder cartDto = CartDto.builder();

        cartDto.userDto( userMapper.toDto( cart.getUser() ) );
        cartDto.productDto( productMapper.toDto( cart.getProduct() ) );
        cartDto.cartId( cartIdToCartIdDto( cart.getCartId() ) );
        cartDto.quantity( cart.getQuantity() );
        cartDto.isDeleted( cart.getIsDeleted() );

        return cartDto.build();
    }

    protected CartId cartIdDtoToCartId(CartIdDto cartIdDto) {
        if ( cartIdDto == null ) {
            return null;
        }

        CartId.CartIdBuilder cartId = CartId.builder();

        if ( cartIdDto.getProductId() != null ) {
            cartId.productId( cartIdDto.getProductId() );
        }
        if ( cartIdDto.getUserId() != null ) {
            cartId.userId( cartIdDto.getUserId() );
        }

        return cartId.build();
    }

    protected CartIdDto cartIdToCartIdDto(CartId cartId) {
        if ( cartId == null ) {
            return null;
        }

        CartIdDto.CartIdDtoBuilder cartIdDto = CartIdDto.builder();

        cartIdDto.userId( cartId.getUserId() );
        cartIdDto.productId( cartId.getProductId() );

        return cartIdDto.build();
    }
}
