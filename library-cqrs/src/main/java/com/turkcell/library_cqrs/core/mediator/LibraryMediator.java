package com.turkcell.library_cqrs.core.mediator;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.core.mediator.cqrs.Query;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

public class LibraryMediator implements Mediator {

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
}
