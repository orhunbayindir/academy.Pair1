package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductRepository
{
    List<Product> getAll();
    Product add(Product product);

    //delete update getbyıd

    void delete(int id);

    Product update(Product product,int id);

    Product getById(int id);


}