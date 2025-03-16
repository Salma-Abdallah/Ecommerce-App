package com.example.ecommerceApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
     @JsonProperty("user")
    private UserDto userDto;
    @JsonProperty("product")
    private ProductDto productDto;
    private Integer quantity;
    private Integer isDeleted;
}
