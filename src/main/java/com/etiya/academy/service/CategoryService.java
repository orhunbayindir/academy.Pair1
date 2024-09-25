package com.etiya.academy.service;

import com.etiya.academy.dto.category.CreateCategoryDto;
import com.etiya.academy.dto.category.CategoryDto;
import com.etiya.academy.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();

    Category add(CreateCategoryDto product);

    void delete(Integer id);

    CategoryDto getById(Integer id);

    CategoryDto update(CreateCategoryDto dto);

}
