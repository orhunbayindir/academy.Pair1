package com.etiya.academy.dto.product;

import com.etiya.academy.dto.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto
{
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;
    private CategoryDto category;
}
