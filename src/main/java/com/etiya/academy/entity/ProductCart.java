package com.etiya.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_carts")
@Entity
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn( name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn( name = "cart_id")
    private Cart cart;

    @Column( name = "quantity")
    private int quantity;
}
