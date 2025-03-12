package com.example.ecommerceApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Builder
@Embeddable
public class CartId  implements Serializable {

    @NotNull
    @Column(name = "cart_product_id", nullable = false)
    private int productId;
    @NotNull
    @Column(name = "cart_user_id", nullable = false)
    private int userId;

    public CartId() {
    }

    public CartId(int productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }



    @Column(name="cart_product_id", nullable=false)
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    @Column(name="cart_user_id", nullable=false)
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof CartId) ) return false;
        CartId castOther = ( CartId ) other;

        return (this.getProductId()==castOther.getProductId())
                && (this.getUserId()==castOther.getUserId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getProductId();
        result = 37 * result + this.getUserId();
        return result;
    }


}


