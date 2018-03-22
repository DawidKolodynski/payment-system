package com.dawid.paymentsystem.model.commands;

import com.dawid.paymentsystem.model.ValidationErrors;

public class CreateUserCommand implements Command{

//    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public void validate(ValidationErrors errors) {
        validatePresence(errors,"firstName", firstName);
        validatePresence(errors,"lastName", lastName);
        validatePresence(errors,"email", email);
    }



//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
