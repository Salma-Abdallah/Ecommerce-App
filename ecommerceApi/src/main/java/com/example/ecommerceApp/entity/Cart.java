package com.example.ecommerceApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart implements Serializable {
    @EmbeddedId
    private CartId cartId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cart_user_id", nullable=false, insertable=false, updatable=false)
    private User user;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cart_product_id", nullable=false, insertable=false, updatable=false)
    private Product product;

    @Column(name="quantity", nullable = false , columnDefinition = "default '1'")
    private Integer quantity;
    @Column(name = "is_deleted" , nullable = false , columnDefinition = "default '0'")
    private Integer isDeleted;

}
