package com.dawid.paymentsystem.model;

public interface UserRepository {

    Integer generateNumber();

    void save(User user);

    User get(Integer userNo);
}
