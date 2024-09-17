package com.etiya.academy.service;

import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductService
{
    // TODO: DTO!
    List<Product> getAll();
    Product add(Product product);

    void delete(int id);

    Product update(Product product,int id);

    Product getById(int id);

}