package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.repository.ProductRepository;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
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