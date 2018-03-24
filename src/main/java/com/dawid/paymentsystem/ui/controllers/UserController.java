package com.dawid.paymentsystem.ui.controllers;

import com.dawid.paymentsystem.api.CommandGateway;
import com.dawid.paymentsystem.api.UserFinder;
import com.dawid.paymentsystem.api.dtos.UserDto;
import com.dawid.paymentsystem.model.commands.CreateUserCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private CommandGateway commandGateway;
    private UserFinder userFinder;

    public UserController(CommandGateway commandGateway, UserFinder userFinder) {
        this.commandGateway = commandGateway;
        this.userFinder = userFinder;
    }

    @PutMapping("/users")
    public void createUser(@RequestBody CreateUserCommand cmd) {
        commandGateway.execute(cmd);
    }

    @GetMapping("/users")
    public List<UserDto> showUsers() {
        return userFinder.getAll();
    }



}
