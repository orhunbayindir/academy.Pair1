package com.etiya.academy.mapper;

import com.etiya.academy.dto.productCart.CreateProductCartDto;
import com.etiya.academy.dto.productCart.ListProductCartDto;
import com.etiya.academy.dto.productCart.ProductCartDto;
import com.etiya.academy.entity.ProductCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductCartMapper {
    ProductCartMapper INSTANCE = Mappers.getMapper(ProductCartMapper.class);

    // ProductCart productCartFromCreateDto(CreateProductCart dto);
    @Mapping(source = "cart.id", target = "cartId")
    ProductCartDto dtoFromProductCart(ProductCart productCart);

    ProductCart productCardFromProductCartDto(ProductCartDto dto);

    @Mapping(source = "cart.id", target = "cartId")
    ListProductCartDto listProductCardDtoFromProductCart(ProductCart productCart);

    ProductCart productCardFromCreateProductCartDto(CreateProductCartDto dto);

}