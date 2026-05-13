package com.turkcell.spring_cqrs.application.features.category.command.create;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;
import com.turkcell.spring_cqrs.core.security.authorization.AuthorizableRequest;
import com.turkcell.spring_cqrs.core.security.authorization.Role;

import jakarta.validation.constraints.NotBlank;

//Command-Query ->DTO
public record CreateCategoryCommand(
    @NotBlank @Length(min=3, max=100) String name,
    String description
) implements Command<CreatedCategoryResponse>, AuthorizableRequest {

   @Override
    public List<Role> requiredRoles() {
        return List.of(Role.ADMIN); 
    }
}
