package com.etiya.academy.service;

import com.etiya.academy.dto.cart.CartDto;
import com.etiya.academy.dto.cart.CreateCartDto;
import com.etiya.academy.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartDto> getAll();

    Cart add(CreateCartDto dto);

    void delete(Integer id);

    CartDto getById(Integer id);

    CartDto update(Integer id, CreateCartDto dto);

    Optional<Cart> findById(Integer id);
}
