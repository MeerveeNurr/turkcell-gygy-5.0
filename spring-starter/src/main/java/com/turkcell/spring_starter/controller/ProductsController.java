package com.turkcell.spring_starter.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductServiceImpl productServiceImpl;

    public ProductsController(ProductServiceImpl productService) {
        this.productServiceImpl = productService;
    }

    @PostMapping
    public void create(@RequestBody CreateProductRequest createProductRequest){
         this.productServiceImpl.create(createProductRequest);
    }

    @GetMapping
    public List<Product> getAll(){
        return productServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable UUID id){
        return productServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable UUID id, @RequestBody Product product){
        return productServiceImpl.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        productServiceImpl.delete(id);
    }
}