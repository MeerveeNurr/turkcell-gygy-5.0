package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.CreateCategoryRequest;
import com.turkcell.spring_starter.dto.CreatedCategoryResponse;
import com.turkcell.spring_starter.dto.ListCategoryResponse;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.repository.CategoryRepository;

import jakarta.persistence.EntityManager;

@Service  
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository; //sağ tık->source action->generate constructors-> ilgili kısmı seç burayı hazır yazıyor.
    }

    public void create(Category category){
        //Veritabanında insert-update çalıştırır.
        //entity id'e sahipse update 
        //entity id'si null ise insert
        this.categoryRepository.save(category);
    }
    


}
