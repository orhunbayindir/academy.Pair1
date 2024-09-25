package com.etiya.academy.dto.product;

import com.etiya.academy.dto.category.CategoryDto;
import com.etiya.academy.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductDto
{
    private int id;
    private String name;
    private BigDecimal unitPrice;
    private CategoryDto category;
}
