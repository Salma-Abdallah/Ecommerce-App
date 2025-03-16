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
public class OrderDetails implements Serializable {
    @EmbeddedId
    private OrderDetailsId orderDetailsId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false, insertable=false, updatable=false)
    private Order order;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
    private Product product;

//    @EmbeddedId
//    @AttributeOverrides( {
//            @AttributeOverride(name="orderId", column=@Column(name="order_id", nullable=false) ),
//            @AttributeOverride(name="productId", column=@Column(name="product_id", nullable=false) ) } )
//    public OrderDetailsId getId() {
//        return this.id;
//    }

}
