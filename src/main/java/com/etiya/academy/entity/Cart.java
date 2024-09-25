package com.etiya.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "cart")
    private List<ProductCart> productCarts;
}