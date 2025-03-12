package com.example.ecommerceApp.repository;

import com.example.ecommerceApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
