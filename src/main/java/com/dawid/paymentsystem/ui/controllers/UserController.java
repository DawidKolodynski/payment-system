package com.dawid.paymentsystem.ui.controllers;

import com.dawid.paymentsystem.api.CardFinder;
import com.dawid.paymentsystem.api.CommandGateway;
import com.dawid.paymentsystem.api.UserFinder;
import com.dawid.paymentsystem.api.dtos.CardDto;
import com.dawid.paymentsystem.api.dtos.UserDto;
import com.dawid.paymentsystem.model.commands.CreateUserCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private CommandGateway commandGateway;
    private UserFinder userFinder;
    private CardFinder cardFinder;

    public UserController(CommandGateway commandGateway, UserFinder userFinder, CardFinder cardFinder) {
        this.commandGateway = commandGateway;
        this.userFinder = userFinder;
        this.cardFinder = cardFinder;
    }

    @PutMapping("/user")
    public void createUser(@RequestBody CreateUserCommand command) {
        commandGateway.execute(command);
    }

    @GetMapping("/users")
    public List<UserDto> showUsers() {
        return userFinder.getAll();
    }

    @GetMapping("/cards/{userId}")
    public List<CardDto> searchCards(@PathVariable Integer userId) {
        return cardFinder.getCards(userId);
    }

}
