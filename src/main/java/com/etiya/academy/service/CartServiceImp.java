package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.cart.CartDto;
import com.etiya.academy.dto.cart.CreateCartDto;
import com.etiya.academy.dto.user.UserDto;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import com.etiya.academy.entity.User;
import com.etiya.academy.mapper.CartMapper;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.mapper.UserMapper;
import com.etiya.academy.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService{

    private final CartRepository cartRepository;
    private final UserService userService;

    @Override
    public List<CartDto> getAll() {
        return cartRepository.findAll().stream()
                .map(CartMapper.INSTANCE::cartDtoFromCart).toList();
    }

    @Override
    public Cart add(CreateCartDto dto) {
        UserDto userDto = userService.getById(dto.getUserId());
        if ( userDto == null)
            throw new BusinessException("Bu id'ye sahip kullanıcı bulunmamaktadır.");
        User user = UserMapper.INSTANCE.userFromDto(userDto);
        Cart cart = CartMapper.INSTANCE.cartFromCreateDto(dto);
        cart.setUser(user);
        cart.setCreatedDate(LocalDate.now());
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public CartDto getById(Integer id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if( cart.isPresent() )
            return CartMapper.INSTANCE.cartDtoFromCart(cart.get());
        return null;
    }

    @Override
    public CartDto update(Integer id, CreateCartDto dto) {
        Optional<Cart> cart = cartRepository.findById(id);
        if( cart.isEmpty() ){
            throw new BusinessException("Bu id'ye sahip Cart yok.");
        }
        UserDto userDto = userService.getById(dto.getUserId());
        if ( userDto == null)
            throw new BusinessException("Bu id'ye sahip kullanıcı bulunmamaktadır.");
        User user = UserMapper.INSTANCE.userFromDto(userDto);
        cart.get().setUser(user);
        return CartMapper.INSTANCE.cartDtoFromCart(cartRepository.save(cart.get()));
    }

    @Override
    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }
}
