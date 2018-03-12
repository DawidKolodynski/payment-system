package com.dawid.paymentsystem.model;

public interface Command {

    default void validate(ValidationErrors validationErrors) {

    }

}
