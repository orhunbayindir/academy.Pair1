package com.etiya.academy.mapper;

import com.etiya.academy.dto.cart.CartDto;
import com.etiya.academy.dto.cart.CreateCartDto;
import com.etiya.academy.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart cartFromCreateDto(CreateCartDto dto);

    CartDto cartDtoFromCart(Cart cart);

}
