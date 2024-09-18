package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository
{
    List<Product> products = new ArrayList<>();
    int id=0;
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product add(Product product) {
        id++;
        product.setId(id);
        products.add(product);
        return product;
    }

    @Override
    public void delete(int id) {
        for(Product nProduct:products){
            if (nProduct.getId()==id){
               products.remove(nProduct);
               break;
            }
        }

    }

    @Override
    public Product update(Product product, int id) {
        for(Product nProduct:products){
            if (nProduct.getId()==id){
                nProduct.setName(product.getName());
                nProduct.setUnitPrice(product.getUnitPrice());
                nProduct.setUnitsInStock(product.getUnitsInStock());
                return nProduct;
            }
        }
        return null;
    }

    @Override
    public Product getById(int id) {
        for(Product product:products){
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }





}