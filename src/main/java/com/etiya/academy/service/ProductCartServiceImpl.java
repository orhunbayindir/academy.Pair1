package com.etiya.academy.service;


import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.productCart.CreateProductCartDto;
import com.etiya.academy.dto.productCart.ListProductCartDto;
import com.etiya.academy.dto.productCart.ProductCartDto;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.Product;
import com.etiya.academy.entity.ProductCart;
import com.etiya.academy.mapper.ProductCartMapper;
import com.etiya.academy.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService
{
    private final ProductCartRepository productCartRepository;
    private final ProductService productService;
    private final CartService cartService;

    @Override
    public List<ListProductCartDto> getAll() {
        return productCartRepository.findAll().stream()
                .map(ProductCartMapper.INSTANCE::listProductCardDtoFromProductCart).toList();
    }

    @Override
    public ProductCart add(CreateProductCartDto dto) {
        Optional<Product> product = productService.findById(dto.getProductId());
        if( product.isEmpty() )
            throw new BusinessException("Bu id'ye sahip ürün yok.");
        Optional<Cart> cart = cartService.findById(dto.getCartId());
        if( cart.isEmpty() )
            throw new BusinessException("Bu id'ye sahip sepet yok.");

        ProductCart productCart = ProductCartMapper.INSTANCE.productCardFromCreateProductCartDto(dto);
        productCart.setProduct(product.get());
        productCart.setCart(cart.get());
        return productCartRepository.save(productCart);
    }

    @Override
    public void delete(Integer id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public ProductCartDto getById(Integer id) {
        Optional<ProductCart> productCart = productCartRepository.findById(id);
        if( productCart.isPresent() )
            return ProductCartMapper.INSTANCE.dtoFromProductCart(productCart.get());
        return null;
    }

    @Override
    public ProductCartDto update(Integer id, CreateProductCartDto dto) {
        Optional<ProductCart> productCart = productCartRepository.findById(id);
        if( productCart.isEmpty() )
            throw new BusinessException("Bu id'ye sahip ProductCart bulunmamaktadır.");
        Optional<Product> product = productService.findById(dto.getProductId());
        if( product.isEmpty() )
            throw new BusinessException("Bu id'ye sahip ürün yok.");
        Optional<Cart> cart = cartService.findById(dto.getCartId());
        if( cart.isEmpty() )
            throw new BusinessException("Bu id'ye sahip sepet yok.");

        ProductCart productCartToBeSaved = ProductCartMapper.INSTANCE.productCardFromCreateProductCartDto(dto);
        productCartToBeSaved.setProduct(product.get());
        productCartToBeSaved.setCart(cart.get());
        return ProductCartMapper.INSTANCE.dtoFromProductCart(productCartRepository.save(productCartToBeSaved));
    }
}
