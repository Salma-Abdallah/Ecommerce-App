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
@Table(name = "user")
public class User implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
   @NotNull
   @Column(name="name" , nullable = false)
    private String name;
    @NotNull
    @Column(name="password" , nullable = false)
    private String password;
    @NotNull
    @Column(name = "email" , nullable = false)
    private String email;
    @NotNull
    @Column(name = "is_admin" , nullable = false , columnDefinition = "default '0'")
    private Integer isAdmin;


}
