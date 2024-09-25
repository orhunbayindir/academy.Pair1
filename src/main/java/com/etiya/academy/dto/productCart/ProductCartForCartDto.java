package com.etiya.academy.dto.productCart;

import com.etiya.academy.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartForCartDto  {
    private int id;
    private ProductDto product;
    private int quantity;
}
