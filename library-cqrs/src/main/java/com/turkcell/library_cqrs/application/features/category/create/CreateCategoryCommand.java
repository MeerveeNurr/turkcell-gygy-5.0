package com.turkcell.library_cqrs.application.features.category.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public record CreateCategoryCommand(String name, String author,String description) implements Command<UUID> {

}
