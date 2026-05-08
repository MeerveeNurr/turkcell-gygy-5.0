package com.turkcell.library_cqrs.core.transaction;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(5)
public class TransactionBehavior implements PipelineBehavior {

    @Override
    public boolean supports(Object request) {
        return true; // genelde sadece Command için yapılır ama şimdilik hepsi
    }

    @Override
    @Transactional
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        return next.invoke();
    }
}