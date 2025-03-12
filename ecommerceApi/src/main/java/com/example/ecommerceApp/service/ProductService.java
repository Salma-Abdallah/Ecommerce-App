package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dto.ProductDto;
import com.example.ecommerceApp.entity.Product;
import com.example.ecommerceApp.mapper.ProductMapper;
import com.example.ecommerceApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){
        List<Product> products= productRepository.findAll();

        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
      }

    public ProductDto getProductByID(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" Product not found with ID: "+id+productRepository.findById(id)));

        return productMapper.toDto(product);
    }

    public ProductDto add(ProductDto productDto){
        Product product = productRepository.save(productMapper.toEntity(productDto));

        return productMapper.toDto(product);
    }

    public void updateQuantity(Integer id , Integer newValue){
         productRepository.updateQuantity(id,newValue);
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
