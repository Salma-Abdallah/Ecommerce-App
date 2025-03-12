package com.example.ecommerceApp.mapper;

import com.example.ecommerceApp.dto.ProductDto;
import com.example.ecommerceApp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


//MappingConstants.ComponentModel.SPRING
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product toEntity (ProductDto productDto);
    ProductDto toDto (Product product);
}
