package com.dawid.paymentsystem.application;

import com.dawid.paymentsystem.model.AddUserCommand;
import com.dawid.paymentsystem.model.Command;
import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddUserHandler implements Handler<AddUserCommand> {

    private UserRepository repository;

    public AddUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void handle(AddUserCommand cmd) {
        User user = new User(
                repository.generateNumber(),
                cmd.getFirstName(),
                cmd.getLastName(),
                cmd.getEmail(),
                cmd.getPassword()
        );

        repository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return null;
    }
}
