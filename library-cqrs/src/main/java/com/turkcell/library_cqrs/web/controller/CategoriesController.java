package com.turkcell.library_cqrs.web.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.query.getAll.GetAllCategoriesQuery;
import com.turkcell.library_cqrs.application.features.category.query.getAll.GetAllCategoriesResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RequestMapping("/api/librarycategories")
@RestController
public class CategoriesController {
    private final Mediator mediator;

    public CategoriesController(Mediator mediator) {
        this.mediator = mediator;
    }
    
    @PostMapping 
    public UUID create(@RequestBody CreateCategoryCommand command){
        return mediator.send(command);
    }
  @GetMapping
  public Page<GetAllCategoriesResponse> getAll(
    @RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize){

        var query=new GetAllCategoriesQuery(pageNumber, pageSize);
//burada mediator ile query'i gönderiyoruz ve sonuç olarak sayfalı bir şekilde kategorileri alıyoruz.
        return mediator.send(query);
    }
}
