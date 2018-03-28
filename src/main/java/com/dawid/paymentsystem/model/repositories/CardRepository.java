package com.dawid.paymentsystem.model.repositories;

import com.dawid.paymentsystem.model.User;

import java.util.Set;

public interface CardRepository {

    Set<User> getCards(Integer userId);

    User get(Integer userId);
}
