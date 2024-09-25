package com.etiya.academy.service;

import com.etiya.academy.dto.productCart.CreateProductCartDto;
import com.etiya.academy.dto.productCart.ListProductCartDto;
import com.etiya.academy.dto.productCart.ProductCartDto;
import com.etiya.academy.entity.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ListProductCartDto> getAll();

    ProductCart add(CreateProductCartDto dto);

    void delete(Integer id);

    ProductCartDto getById(Integer id);

    ProductCartDto update(Integer id, CreateProductCartDto dto);
}
