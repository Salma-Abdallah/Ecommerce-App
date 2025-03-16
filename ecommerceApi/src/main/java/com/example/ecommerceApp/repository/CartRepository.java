package com.example.ecommerceApp.repository;

import com.example.ecommerceApp.entity.Cart;
import com.example.ecommerceApp.entity.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, CartId> {
    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.quantity = :quantity WHERE c.cartId = :cartId ")
    int updateCartQuantity(@Param("cartId") CartId cartId, @Param("quantity") Integer quantity);

//    List<Cart> findByUserId(Integer userId);

    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.isDeleted = 0")
    List<Cart> findByUserId(@Param("userId") Integer userId);

    Optional<Cart> findByCartId(CartId cartId);
}
