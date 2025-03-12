package com.example.ecommerceApp.controller;

import com.example.ecommerceApp.dto.ProductDto;
import com.example.ecommerceApp.entity.Product;
import com.example.ecommerceApp.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//    }

    @GetMapping("/{id}")
//    public Optional<Product> getProductById(@PathVariable Integer id){
//        return productService.getProductByID(id);
//    }
    public ProductDto getProductById(@PathVariable Integer id){
        return productService.getProductByID(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return productService.add(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.ok("Product with ID " + id + " deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductQuantity(@PathVariable Integer id, @RequestBody Integer qantity){
        productService.updateQuantity(id,qantity);
        return ResponseEntity.ok("Product with ID " + id + " updated successfully 👍");
    }
}
