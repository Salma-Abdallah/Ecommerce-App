package com.example.ecommerceApp.repository;

import com.example.ecommerceApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product m SET m.quantity = :newValue WHERE m.id = :id")
    int updateQuantity(@Param("id") Integer id, @Param("newValue") Integer newValue);
}
