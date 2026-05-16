package com.turkcell.library_cqrs.application.features.category.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.command.create.CreatedCategoryResponse;
import com.turkcell.library_cqrs.domain.Books;

@Component
public class CategoryMapper {
    public Books categoryFromCreateCommand(CreateCategoryCommand command)
    {
        Books category = new Books();
        category.setBookName(command.name());
        return category;
    }
    public CreatedCategoryResponse createdCategoryResponseFromCategory(Books category)
    {
        return new CreatedCategoryResponse(category.getId(),category.getBookName());
    }
}