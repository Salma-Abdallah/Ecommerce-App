package com.example.ecommerceApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Embeddable
public class OrderDetailsId  implements Serializable {
    @NotNull
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @NotNull
    @Column(name = "product_id", nullable = false)
    private int productId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }



    @Column(name="order_id", nullable=false)
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Column(name="product_id", nullable=false)
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof OrderDetailsId) ) return false;
        OrderDetailsId castOther = ( OrderDetailsId ) other;

        return (this.getOrderId()==castOther.getOrderId())
                && (this.getProductId()==castOther.getProductId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrderId();
        result = 37 * result + this.getProductId();
        return result;
    }


}


