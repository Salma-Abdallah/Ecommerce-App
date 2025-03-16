package com.example.ecommerceApp.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.example.ecommerceApp.dto.CartIdDto;
import com.example.ecommerceApp.entity.CartId;
import org.mapstruct.ReportingPolicy;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CartIdMapper {
    CartId toEntity (CartIdDto cartIdDto );
    CartIdDto tDto (CartId cartId);
    
} 
