package com.turkcell.library_cqrs.core.logging;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

import tools.jackson.databind.ObjectMapper;

@Component
@Order(10)
public class LoggingBehavior implements PipelineBehavior {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(Object request) {
        return !(request instanceof NotLoggableRequest);
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {

        try {
            String requestName = request.getClass().getSimpleName();

            System.out.println("📥 REQUEST: " + requestName);
            System.out.println("📥 DATA: " + objectMapper.writeValueAsString(request));

            long start = System.currentTimeMillis();

            R response = next.invoke();

            long end = System.currentTimeMillis();

            System.out.println("📤 RESPONSE: " + requestName);
            System.out.println("📤 DATA: " + objectMapper.writeValueAsString(response));
            System.out.println("⏱️ TIME: " + (end - start) + " ms");

            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}