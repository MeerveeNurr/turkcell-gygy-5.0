package com.turkcell.library_cqrs.core.mediator;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.Query;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class LibraryMediator implements Mediator {
    private final ApplicationContext context;

    public LibraryMediator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <R> R send(Command<R> command) {
        var handler = (CommandHandler<Command<R>, R>) resolveHandler(command.getClass(), CommandHandler.class);

        return handler.handle(command);
    }

    @Override
    public <R> R send(Query<R> query) {
        var handler = (QueryHandler<Query<R>, R>) resolveHandler(query.getClass(), QueryHandler.class);

        return handler.handle(query);
    }

   //Hangi Command/Query - Hangi Handler
  private <T> T resolveHandler(Class<?> requestType, Class<T> handlerInterface) {
    Class<?> returnType = ResolvableType.forClass(requestType)
                                        .as(Command.class)
                                        .getGeneric(0)
                                        .resolve();

    ResolvableType handlerType = ResolvableType.forClassWithGenerics(
        handlerInterface, 
        requestType, 
        returnType
    );

    String[] beanNames = context.getBeanNamesForType(handlerType);

    if (beanNames.length == 0) {
        throw new IllegalStateException(requestType.getSimpleName() + " için uygun Handler bulunamadı.");
    }

    return (T) context.getBean(beanNames[0]);
}
}
