package com.turkcell.spring_cqrs.application.features.category.query.getAll;

import java.util.List;

import org.springframework.data.domain.Page;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Query;
import com.turkcell.spring_cqrs.core.security.authorization.AuthorizableRequest;
import com.turkcell.spring_cqrs.core.security.authorization.Role;

public record GetAllCategoriesQuery(int pageNumber,int pageSize)implements Query<Page<GetAllCategoriesResponse>>,
           AuthorizableRequest {

    @Override
    public List<Role> requiredRoles() {

        return List.of(Role.ADMIN);
    }
}