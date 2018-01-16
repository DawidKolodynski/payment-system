package com.dawid.paymentsystem.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(Integer id);

//    Integer generateNumber();
//
//    void save(User user);
//
//    User get(Integer userNo);
}
