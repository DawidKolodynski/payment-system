package com.dawid.paymentsystem.api;


import com.dawid.paymentsystem.api.handlers.Handler;
import com.dawid.paymentsystem.model.commands.ValidationErrors;
import com.dawid.paymentsystem.model.commands.Command;
import com.dawid.paymentsystem.model.commands.CommandInvalidException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CommandGateway {

    private ApplicationContext applicationContext;

    public CommandGateway(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T execute(Command command) {
        validate(command);
        Handler handler = handlerFor(command);
       return (T) handler.handle(command);
    }

    private Handler handlerFor(Command command) {
        Map<String, Handler> handlers = applicationContext.getBeansOfType(Handler.class);
        Optional<Handler> handlerOptional = handlers.values().stream().
                filter((h) -> h.canHandle(command)).findFirst();
        return handlerOptional.orElseThrow(() ->
                new IllegalArgumentException("No handler found for " + command.getClass()));
    }

    private void validate(Command command) {
        ValidationErrors errors = new ValidationErrors();
        command.validate(errors);
        if(errors.any())
            throw new CommandInvalidException(errors);
    }
}
