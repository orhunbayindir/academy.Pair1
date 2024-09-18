package com.etiya.academy.service;

import com.etiya.academy.dto.product.CreateProductDto;
import com.etiya.academy.dto.product.ListProductDto;
import com.etiya.academy.dto.product.ProductDto;
import com.etiya.academy.dto.product.UpdateProductDto;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    @Override
    public List<ListProductDto> getAll() {
        // Business Logic -> Loglama, Auth, İş Kuralları, Validasyonlar
        // Veri Erişim -> DB'e git verileri oku "Select * from Products"
        // bla bla..
        return productRepository.getAll().stream()
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
            throw new RuntimeException("Ürün ismi 3 haneden kısa olamaz.");

        // Stok değeri 0'dan küçük esit ise sipariş verilemez.
        // 1 validasyon (verinin üstünde olan bir kullanım) (constraint kısıt)
        // 2 iş kuralı
        if (product.getUnitsInStock()<0)
            throw new RuntimeException("Ürün stoğu 0'dan küçük olamaz.");
        if (product.getUnitPrice()<0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");

        Product product1 = ProductMapper.INSTANCE.productFromCreateDto(product);


       return productRepository.add(product1);

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public ProductDto update(UpdateProductDto dto, int id) {
        if(dto.getName().length() < 3)
            throw new RuntimeException("Ürün ismi 3 haneden kısa olamaz.");
        if (dto.getUnitsInStock()<0)
            throw new RuntimeException("Ürün stoğu 0'dan küçük olamaz.");
        if (dto.getUnitPrice()<0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");

        Product product = ProductMapper.INSTANCE.productFromUpdateDto(dto);
        return ProductMapper.INSTANCE.dtoFromProduct(productRepository.update(product,id));
    }

    @Override
    public ProductDto getById(int id) {
        return ProductMapper.INSTANCE.dtoFromProduct(productRepository.getById(id));
    }
}
