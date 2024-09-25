package com.etiya.academy.dto.cart;

import com.etiya.academy.dto.productCart.ProductCartForCartDto;
import com.etiya.academy.dto.user.UserDto;
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
public class CartDto {
    private int id;
    private LocalDate createdDate;
    private UserDto user;
    private List<ProductCartForCartDto> productCarts;
}
