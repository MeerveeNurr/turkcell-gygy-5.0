package com.turkcell.library_cqrs.core.mediator;

public interface Mediator {
  <R> R send(Command<R> command);
  <R> R send(Query<R> query);
}
