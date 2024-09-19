package com.etiya.academy.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Boilerplate -> Basmakalıp

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double unitPrice;
    private int unitsInStock;

    @ManyToOne
    private Category category;
}