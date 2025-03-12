package com.example.ecommerceApp.dto;

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
    private Integer userId;
    private Integer productId;
    private Integer quantity;
}
