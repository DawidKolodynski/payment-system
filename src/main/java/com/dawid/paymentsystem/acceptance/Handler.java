package com.dawid.paymentsystem.acceptance;


import com.dawid.paymentsystem.model.Command;

public interface Handler<C extends Command> {

    void handle(C command);

    Class<? extends Command> getSupportedCommandClass();

    default boolean canHandle(Command command) {
        return command.getClass().equals(getSupportedCommandClass());
    }


}
