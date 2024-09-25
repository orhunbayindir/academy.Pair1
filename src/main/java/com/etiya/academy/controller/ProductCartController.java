package com.etiya.academy.controller;

import com.etiya.academy.dto.productCart.CreateProductCartDto;
import com.etiya.academy.dto.productCart.ListProductCartDto;
import com.etiya.academy.dto.productCart.ProductCartDto;
import com.etiya.academy.entity.ProductCart;
import com.etiya.academy.service.ProductCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-carts")
@RequiredArgsConstructor
public class ProductCartController
{
    private final ProductCartService productCartService;

    @GetMapping()
    public ResponseEntity<List<ListProductCartDto>> getAll() {
        return ResponseEntity.ok(productCartService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CreateProductCartDto productCartDto)
    {
        ProductCart productCart = productCartService.add(productCartDto);
        if (productCart != null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(404).build();
    }

    @GetMapping("id")
    public ResponseEntity<ProductCartDto> getById(@RequestParam Integer id){
        ProductCartDto productCartDto = productCartService.getById(id);
        if (productCartDto != null)
            return ResponseEntity.ok(productCartDto);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        productCartService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCartDto> update(@PathVariable Integer id, @RequestBody @Valid CreateProductCartDto dto){
        ProductCartDto productCartDto = productCartService.update(id, dto);
        return ResponseEntity.status(200).body(productCartDto);
    }

}