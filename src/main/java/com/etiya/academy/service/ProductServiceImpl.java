package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.ProductRepository;
import com.etiya.academy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<ListProductDto> getAll() {
        // Business Logic -> Loglama, Auth, İş Kuralları, Validasyonlar
        // Veri Erişim -> DB'e git verileri oku "Select * from Products"
        // bla bla..
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::listDtoFromProduct).toList();
    }

    // Validasyon -> Direkt verinin üzerinde farklı veri gerektirmeden yapılabilen kontrollerdir.
    // İş Kuralı -> genelde diğer verilerle karşılaştırma üzerine bir yapıdır. -> Aynı isimde bir ürün var mı?
    // halit@kodlama.io
    // Eposta adresi @ işareti içermelidir - 1 Validasyon
    // Aynı e posta ile bir üye bulunmamalıdır. - 2 İş Kuralı
    @Override
    public Product add(CreateProductDto product) {
        if(product.getName().length() < 3)
            throw new BusinessException("Ürün ismi 3 haneden kısa olamaz.");

        // Stok değeri 0'dan küçük esit ise sipariş verilemez.
        // 1 validasyon (verinin üstünde olan bir kullanım) (constraint kısıt)
        // 2 iş kuralı

        boolean productWithSameName = productRepository.findAll()
                .stream()
                .anyMatch(p -> product.getName().equals(p.getName()));
        if(productWithSameName)
            throw new BusinessException("Böyle bir ürün zaten var.");

        Optional <Category> category = categoryRepository.findById(product.getCategoryId());
        if (category.isEmpty())
            throw new BusinessException("Kategori seçilmelidir.");
        Product product1 = ProductMapper.INSTANCE.productFromCreateDto(product);
        product1.setCategory(category.get());

        return productRepository.save(product1);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto update(UpdateProductDto dto) {
        if(dto.getName().length() < 3)
            throw new BusinessException("Ürün ismi 3 haneden kısa olamaz.");

        boolean productWithSameName = productRepository.findAll()
                .stream()
                .anyMatch(p -> dto.getName().equals(p.getName()));
        if(productWithSameName)
            throw new BusinessException("Böyle bir ürün zaten var.");

        Product product = ProductMapper.INSTANCE.productFromUpdateDto(dto);
        return ProductMapper.INSTANCE.dtoFromProduct(productRepository.save(product));
    }

    @Override
    public ProductDto getById(Integer id) {
        return ProductMapper.INSTANCE.dtoFromProduct(productRepository.getById(id));
    }
}
