package com.etiya.academy.controller;

import com.etiya.academy.dto.category.CategoryDto;
import com.etiya.academy.dto.category.CreateCategoryDto;
import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Category;
import com.etiya.academy.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAll() {

        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody @Valid CreateCategoryDto category)
    {
        Category category1= categoryService.add(category);
        if (category1!=null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(404).build();

    }

    @GetMapping("id")
    public ResponseEntity<CategoryDto> getById(@RequestParam Integer id){
        CategoryDto category=categoryService.getById(id);
        if (category!=null)
            return ResponseEntity.ok(category);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Integer id, @RequestBody @Valid CreateCategoryDto dto){

        CategoryDto category1=categoryService.update(id, dto);

        return ResponseEntity.status(200).body(category1);
    }
}
