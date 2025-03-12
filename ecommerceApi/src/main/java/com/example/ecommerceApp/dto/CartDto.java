package com.example.ecommerceApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private CartIdDto cartId;
    private UserDto userDto;
    private ProductDto productDto;
    private Integer quantity;
    private Integer isDeleted;
}
