package com.etiya.academy.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto
{
    // Ürün ekleme işleminde gerekli alanları tanımlayabileceğim nesne.
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal unitPrice;

    @NotNull
    @PositiveOrZero
    private int unitsInStock;

    @NotBlank
    private Integer categoryId;
}
