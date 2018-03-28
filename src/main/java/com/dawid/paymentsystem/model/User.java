package com.dawid.paymentsystem.model;


import com.dawid.paymentsystem.model.commands.CreateUserCommand;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @ElementCollection
    private Set<String> cards;


    public User(CreateUserCommand command) {
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.email = command.getEmail();
        this.password = command.getPassword();
        this.cards = command.getCards();
    }

    public User(Set<String> cards) {
        this.cards = cards;
    }

    public User() {
    }

}
