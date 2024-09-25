package com.etiya.academy.service;

import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    // TODO: DTO!
    List<ListProductDto> getAll();
    Product add(CreateProductDto product);

    void delete(Integer id);

    ProductDto update(Integer id, UpdateProductDto dto);

    ProductDto getById(Integer id);

    Optional<Product> findById(Integer id);

}