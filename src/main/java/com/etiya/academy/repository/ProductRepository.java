package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    List<Product> findAll();
//    Product save(Product product);
//
//    //delete update getbyıd
//
    void deleteById(Long id);
//
//    Product getById(int id);

}