package com.example.ecommerceApp.mapper;

import com.example.ecommerceApp.dto.CartIdDto;
import com.example.ecommerceApp.entity.CartId;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T22:00:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CartIdMapperImpl implements CartIdMapper {

    @Override
    public CartId toEntity(CartIdDto cartIdDto) {
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

    @Override
    public CartIdDto tDto(CartId cartId) {
        if ( cartId == null ) {
            return null;
        }

        CartIdDto.CartIdDtoBuilder cartIdDto = CartIdDto.builder();

        cartIdDto.userId( cartId.getUserId() );
        cartIdDto.productId( cartId.getProductId() );

        return cartIdDto.build();
    }
}
