package com.turkcell.library_cqrs.core.performance;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(20)
public class PerformanceBehavior implements PipelineBehavior {

    private static final long THRESHOLD = 3000;

    @Override
    public boolean supports(Object request) {
        return true;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {

        long start = System.currentTimeMillis();

        R response = next.invoke();

        long duration = System.currentTimeMillis() - start;

        if (duration > THRESHOLD) {
            System.out.println("⚠️ PERFORMANCE WARNING: "
                    + request.getClass().getSimpleName()
                    + " took " + duration + " ms");
        }

        return response;
    }
}
