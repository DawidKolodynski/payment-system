package com.dawid.paymentsystem.model.repositories;

import com.dawid.paymentsystem.model.User;

public interface UserRepository  {

    void save(User user);

    User get(Integer userId);

    boolean alreadyExist(String firstName, String lastName, String email);

}
