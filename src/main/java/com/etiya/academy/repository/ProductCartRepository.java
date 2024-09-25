package com.etiya.academy.repository;

import com.etiya.academy.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
    List<ProductCart> findAll();
    void deleteById(Integer id);

}
