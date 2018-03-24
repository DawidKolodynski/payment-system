package com.dawid.paymentsystem.api.handlers;


import com.dawid.paymentsystem.model.commands.Command;

public interface Handler<C extends Command,R> {

    R handle(C command);

    Class<? extends Command> getSupportedCommandClass();

    default boolean canHandle(Command command) {
        return command.getClass().equals(getSupportedCommandClass());
    }

}
