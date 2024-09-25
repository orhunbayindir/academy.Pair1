package com.etiya.academy.dto.productCart;

import com.etiya.academy.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDto {
    private int id;
    private ProductDto product;
    private int cartId;
    private int quantity;
}
