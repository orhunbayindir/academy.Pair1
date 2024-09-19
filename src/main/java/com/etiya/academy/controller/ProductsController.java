package com.etiya.academy.controller;

import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Product;
import com.etiya.academy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// ProductController'daki 5 temel operasyonu kodlamak
// getall -> 200
// getbyid -> eğer id ile bir veriye rastlanmaz ise, status code 404 olsun.
// update-delete -> 200
// add -> eğer başarılı ise status code 201 dönsün.

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor // -> final olarak işaretlenen tüm arg. içeren ctor.
public class ProductsController
{
    private final ProductService productService;
    //5 temel operasyon (CRUD)

    @GetMapping()
    public ResponseEntity<List<ListProductDto>> getAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CreateProductDto product)
    {
        Product product1= productService.add(product);
        if (product1!=null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(404).build();

    }



    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){

        ProductDto product=productService.getById(id);
        if (product!=null)
            return ResponseEntity.ok(product);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ProductDto> update(@RequestBody UpdateProductDto dto){

        ProductDto product1=productService.update(dto);

        return ResponseEntity.status(200).body(product1);
    }









}