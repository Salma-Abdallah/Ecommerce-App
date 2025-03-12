package com.example.ecommerceApp.mapper;


import com.example.ecommerceApp.dto.CartDto;
import com.example.ecommerceApp.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        uses = {UserMapper.class, ProductMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CartMapper {
    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "productDto", target = "product")
    Cart toEntity(CartDto cartDto);

    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "product", target = "productDto")
    CartDto toDto(Cart cart);

}
