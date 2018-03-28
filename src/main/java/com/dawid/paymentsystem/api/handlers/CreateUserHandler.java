package com.dawid.paymentsystem.api.handlers;

import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.commands.ValidationErrors;
import com.dawid.paymentsystem.model.commands.Command;
import com.dawid.paymentsystem.model.commands.CommandInvalidException;
import com.dawid.paymentsystem.model.commands.CreateUserCommand;
import com.dawid.paymentsystem.model.repositories.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreateUserHandler implements Handler<CreateUserCommand, Void> {

    private UserRepository repository;
    private ValidationErrors errors;

    public CreateUserHandler(UserRepository repository, ValidationErrors errors) {
        this.repository = repository;
        this.errors = errors;
    }

    @Override
    @Transactional
    public Void handle(CreateUserCommand command) {
        User user = new User(command);
        validateUserExist(command);
        repository.save(user);
        return null;
    }

    private void validateUserExist(CreateUserCommand command) {
        if(alreadyExist(command.getFirstName(), command.getLastName(), command.getEmail())) {
            errors.add("lastName", "such user already exist");
            throw new CommandInvalidException(errors);
        }
    }

    private boolean alreadyExist(String firstName,String lastName, String email) {
        return repository.alreadyExist(firstName, lastName, email);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return CreateUserCommand.class;
    }

}
