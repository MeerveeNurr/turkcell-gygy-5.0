package com.turkcell.library_cqrs.core.mediator.cqrs;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public interface CommandHandler<C extends Command<R>,R> {
 R handle(C Command);
}
