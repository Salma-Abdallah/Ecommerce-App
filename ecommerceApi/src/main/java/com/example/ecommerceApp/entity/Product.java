package com.example.ecommerceApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name="name" , nullable = false)
    private String name;
    @Column(name = "price" ,nullable = false)
    private Integer price;
    @Column(name = "quantity" ,nullable = false)
    private Integer quantity;
    @Column(name = "description", nullable = false)
    private String description;
}
