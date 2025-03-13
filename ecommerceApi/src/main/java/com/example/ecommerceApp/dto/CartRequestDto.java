package com.example.ecommerceApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartRequestDto {
    @JsonProperty("UserId")
    private Integer userId;
    @JsonProperty("ProductId")
    private Integer productId;
    @JsonProperty("Quantity")
    private Integer quantity;
}
