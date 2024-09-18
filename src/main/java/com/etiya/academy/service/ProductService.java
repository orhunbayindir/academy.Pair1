package com.etiya.academy.service;

import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductService
{
    // TODO: DTO!
    List<ListProductDto> getAll();
    Product add(CreateProductDto product);

    void delete(int id);

    ProductDto update(UpdateProductDto dto, int id);

    ProductDto getById(int id);

}