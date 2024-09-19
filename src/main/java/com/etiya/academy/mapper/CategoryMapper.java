package com.etiya.academy.mapper;

import com.etiya.academy.dto.category.CreateCategoryDto;
import com.etiya.academy.dto.category.CategoryDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromCreateDto(CreateCategoryDto dto);

    CategoryDto dtoFromCategory(Category category);

}
