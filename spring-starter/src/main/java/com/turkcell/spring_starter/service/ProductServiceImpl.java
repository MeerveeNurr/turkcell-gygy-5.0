package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.repository.ProductRepository;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final CategoryServiceImpl categoryServiceImpl;


    public ProductServiceImpl(ProductRepository productRepository,CategoryServiceImpl categoryServiceImpl) {
        this.productRepository = productRepository;
        this.categoryServiceImpl=categoryServiceImpl;
    }

       
    public void create(@RequestBody CreateProductRequest createProductRequest)
    {
        // 1. -> Eklenmek istenen ürünün kategorisi var olmalıdır.
        Category category = categoryServiceImpl.getById(createProductRequest.categoryId());

        if(category == null)
            throw new RuntimeException("Böyle bir kategori bulunamadı.");

        Product product = new Product();
        product.setName(createProductRequest.name());
        product.setDescription(createProductRequest.description());
        product.setCategory(category);

        productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(UUID id){
        return productRepository.findById(id).orElseThrow();
    }

    public Product update(UUID id, Product product){
        Product existing = productRepository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }

    public void delete(UUID id){
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }
}