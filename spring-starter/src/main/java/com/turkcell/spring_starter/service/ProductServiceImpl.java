package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.ProductCreatedResponse;
import com.turkcell.spring_starter.dto.ProductForCreateDto;
import com.turkcell.spring_starter.model.Product;

//Impl=Implementation
//Java' da IProductService ❌ şeklinde bir kullanım yok
//ProductService ✅
//ProductServiceImpl ✅
@Service //Bu class bir service'dir.İçini uygulama başladığında tara, iş kodlarını al.
// IoC'e bu türü ekledin.
//IoC Container -> Spring'in bizim için oluşturduğu bir yapı. Bu yapıya bean denir. Bean'ler, Spring tarafından yönetilen nesnelerdir. Bean'ler, Spring tarafından oluşturulur, yönetilir ve yok edilir. Bean'ler, Spring'in IoC Container'ına eklenir ve bu sayede Spring, bu nesneleri ihtiyaç duyulduğunda otomatik olarak enjekte eder.
public class ProductServiceImpl {
     //Controller'in size aktaracağı işleri tanımla.
     //Spring IoC 
     // Controller'ın size aktaracağı işleri tanımla.
    // iş kodu..

    // repo
    private final List<Product> productsInMemory = new ArrayList<>();

    public ProductCreatedResponse create(ProductForCreateDto productDto)
    {
        // Aynı isimde 2 ürün olamaz

        // Business Rule

        checkIfProductWithSameNameExist(productDto.getName());
        
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(new Random().nextInt(999));

        productsInMemory.add(product); // repo

        ProductCreatedResponse response = new ProductCreatedResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());

        return response;
    }

    public void update() {
        // Aynı iş kuralı..
        checkIfProductWithSameNameExist("");
    }

    // İş kuralları -> Kendine has bir classta bulunmalıdır. -> ProductBusinessRules.java
    private void checkIfProductWithSameNameExist(String name) {
        Product productWithSameName = productsInMemory
                                        .stream()
                                        .filter(product->product.getName().equals(name))
                                        .findFirst()
                                        .orElse(null);

        if(productWithSameName != null)
            throw new RuntimeException("Aynı isimde 2 ürün eklenemez");
    }
}
// Auto-generated --Java'da 
// IProductRepository -> ProductRepository --> .Net' de böyle 
// ProductRepository <Product> -> Spring auto-generated. -->Java'da böyle
//.NET → sen implement ediyorsun Spring → framework senin yerine yapıyor
// Spring IoC Nedir? Bean,Service nedir? 

//resources dosyasındaki application.properties dosyası'na server.port=8081 yazarsak uygulama 8081 portunda çalışır.
//Veritabanı bağlantısı da bu dosyadan verilir.