package com.turkcell.library_cqrs.application.features.user.query.getAll;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.Books;
import com.turkcell.library_cqrs.persistance.repository.CategoryRepository;

@Component
public class GetAllCategoriesQueryHandler implements 
    QueryHandler<GetAllCategoriesQuery, Page<GetAllCategoriesResponse>>
{
    private final CategoryRepository categoryRepository;

    public GetAllCategoriesQueryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<GetAllCategoriesResponse> handle(GetAllCategoriesQuery query) {
        // Hibernate sana sağladığı bir özellik.
        Pageable pageable = PageRequest.of(query.pageNumber(), query.pageSize());

        Page<Books> categories = categoryRepository.findAll(pageable);

        // mapper'a ekle.
        return categories.map(category -> new GetAllCategoriesResponse(category.getId(), category.getBookName()));
    }

}