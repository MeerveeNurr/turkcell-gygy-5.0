package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.CreateCategoryRequest;
import com.turkcell.spring_starter.dto.CreatedCategoryResponse;
import com.turkcell.spring_starter.dto.ListCategoryResponse;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.repository.CategoryRepository;

@Service  
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreatedCategoryResponse create(Product product){
        Category category = new Category();
        category.setName(product.getName());

        category = this.categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public List<ListCategoryResponse> getAll(){
        List<Category> categories = this.categoryRepository.findAll();
        List<ListCategoryResponse> responseList = new ArrayList<>();

        for(Category category:categories){
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }
        return responseList;
    }

    public ListCategoryResponse getById(UUID id){
        Category category = this.categoryRepository.findById(id).orElseThrow();

        ListCategoryResponse response = new ListCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public CreatedCategoryResponse update(UUID id, CreateCategoryRequest request){
        Category category = this.categoryRepository.findById(id).orElseThrow();
        category.setName(request.getName());

        category = this.categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public void delete(UUID id){
        Category category = this.categoryRepository.findById(id).orElseThrow();
        this.categoryRepository.delete(category);
    }
}