package com.turkcell.library_cqrs.application.features.category.query.getAll;

import org.springframework.data.domain.Page;

import com.turkcell.library_cqrs.core.mediator.cqrs.Query;

public record GetAllCategoriesQuery(int pageNumber, int pageSize) implements Query<Page<GetAllCategoriesResponse>> {}