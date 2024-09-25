package com.etiya.academy.controller;

import com.etiya.academy.dto.cart.CartDto;
import com.etiya.academy.dto.cart.CreateCartDto;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping()
    public ResponseEntity<List<CartDto>> getAll() {
        return ResponseEntity.ok(cartService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CreateCartDto cartDto)
    {
        Cart cart = cartService.add(cartDto);
        if (cart != null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(404).build();
    }

    @GetMapping("id")
    public ResponseEntity<CartDto> getById(@RequestParam Integer id){
        CartDto cart = cartService.getById(id);
        if (cart != null)
            return ResponseEntity.ok(cart);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cartService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDto> update(@PathVariable Integer id, @RequestBody @Valid CreateCartDto dto){
        CartDto cart = cartService.update(id, dto);
        return ResponseEntity.status(200).body(cart);
    }
}
