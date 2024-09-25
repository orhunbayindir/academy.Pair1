package com.etiya.academy.dto.productCart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCartDto {
    @NotNull
    @Positive
    private int productId;

    @NotNull
    @Positive
    private int cartId;

    @NotNull
    @Positive
    private int quantity;

}
