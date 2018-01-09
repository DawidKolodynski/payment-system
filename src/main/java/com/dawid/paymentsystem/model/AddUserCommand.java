package com.dawid.paymentsystem.model;

public class AddUserCommand implements Command {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

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

    public void validate(ValidationErrors errors) {
        validatePresence(errors, "firstName", firstName);
        validatePresence(errors, "lastName", lastName);
        validatePresence(errors, "email", email);
        validatePresence(errors, "password", password);
    }
}