package com.turkcell.library_cqrs.application.features.category.create;

import java.util.UUID;

public record  CreatedCategoryResponse(UUID id, String name) {

}
