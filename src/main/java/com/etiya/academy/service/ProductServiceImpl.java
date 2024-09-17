package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
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
    public List<Product> getAll() {
        // Business Logic -> Loglama, Auth, İş Kuralları, Validasyonlar
        // Veri Erişim -> DB'e git verileri oku "Select * from Products"
        // bla bla..
        return productRepository.getAll();
    }
    // Validasyon -> Direkt verinin üzerinde farklı veri gerektirmeden yapılabilen kontrollerdir.
    // İş Kuralı -> genelde diğer verilerle karşılaştırma üzerine bir yapıdır. -> Aynı isimde bir ürün var mı?

    // halit@kodlama.io
    // Eposta adresi @ işareti içermelidir - 1 Validasyon
    // Aynı e posta ile bir üye bulunmamalıdır. - 2 İş Kuralı
    @Override
    public Product add(Product product) {

        if (getById(product.getId())!= null)
            throw new RuntimeException("Farklı bir id giriniz.");

        if(product.getName().length() < 3)
            throw new RuntimeException("Ürün ismi 3 haneden kısa olamaz.");


        // Stok değeri 0'dan küçük esit ise sipariş verilemez.
        // 1 validasyon (verinin üstünde olan bir kullanım) (constraint kısıt)
        // 2 iş kuralı
        if (product.getUnitsInStock()<0)
            throw new RuntimeException("Ürün stoğu 0'dan küçük olamaz.");
        if (product.getUnitPrice()<0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");


       return productRepository.add(product);

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product update(Product product, int id) {
        if(product.getName().length() < 3)
            throw new RuntimeException("Ürün ismi 3 haneden kısa olamaz.");
        if (product.getUnitsInStock()<0)
            throw new RuntimeException("Ürün stoğu 0'dan küçük olamaz.");
        if (product.getUnitPrice()<0)
            throw new RuntimeException("Ürün fiyatı 0'dan küçük olamaz.");


        return productRepository.update(product,id);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }
}
