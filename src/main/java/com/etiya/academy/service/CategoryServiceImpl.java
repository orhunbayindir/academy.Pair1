package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.category.CreateCategoryDto;
import com.etiya.academy.dto.category.CategoryDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.CategoryMapper;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::dtoFromCategory).toList();
    }

    @Override
    public Category add(CreateCategoryDto category) {


        if(category.getName().length() < 3)
            throw new BusinessException("Kategori ismi 3 haneden kısa olamaz.");

        boolean categoryWithSameName = categoryRepository.findAll()
                .stream()
                .anyMatch(c -> category.getName().equals(c.getName()));
        if(categoryWithSameName)
            throw new BusinessException("Böyle bir kategori zaten var.");

        Category category1 = CategoryMapper.INSTANCE.categoryFromCreateDto(category);
        return categoryRepository.save(category1);

    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto getById(Long id) {
        return CategoryMapper.INSTANCE.dtoFromCategory(categoryRepository.getById(id));
    }

    @Override
    public CategoryDto update(CreateCategoryDto dto) {

        if(dto.getName().length() < 3)
            throw new BusinessException("Kategori ismi 3 haneden kısa olamaz.");

        boolean categoryWithSameName = categoryRepository.findAll()
                .stream()
                .anyMatch(c -> dto.getName().equals(c.getName()));
        if(categoryWithSameName)
            throw new BusinessException("Böyle bir kategori zaten var.");

        Category category = CategoryMapper.INSTANCE.categoryFromCreateDto(dto);
        return CategoryMapper.INSTANCE.dtoFromCategory(categoryRepository.save(category));
    }
}
