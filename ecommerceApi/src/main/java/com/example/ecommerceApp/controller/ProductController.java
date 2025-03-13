package com.example.ecommerceApp.controller;

import com.example.ecommerceApp.dto.ProductDto;
import com.example.ecommerceApp.entity.Product;
import com.example.ecommerceApp.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<ProductDto> productDtos = productService.getAllProducts();

        if(productDtos.isEmpty()){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "No Products found");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", productDtos); 
            response.put("Message", "get all products successful");

            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        ProductDto productDto = productService.getProductByID(id);
        if(productDto.equals(null)){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "No Products found");
    
            return ResponseEntity.status(404).body(errorResponse);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", productDto); 
            response.put("Message", "get product successful");

            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        ProductDto product = productService.add(productDto);

        if(productDto.equals(null)){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Success", false);
            errorResponse.put("Message", "Can't Add Product");
    
            return ResponseEntity.status(404).body(errorResponse);
        }

        else{
            Map<String, Object> response = new HashMap<>();
            response.put("Success", true);
            response.put("Data", product); 
            response.put("Message", "Add product successful");

            return ResponseEntity.ok(response);
        }
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
