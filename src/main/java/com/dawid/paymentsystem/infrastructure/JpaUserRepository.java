package com.dawid.paymentsystem.infrastructure;

import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.repositories.UserRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.math.BigInteger;

@Component
public class JpaUserRepository extends GenericJpaRepository<User> implements UserRepository {


    @Override
    public User get(Integer userId) {
        return null;
    }

    @Override
    public boolean alreadyExist(String firstName, String lastName, String email) {
        Query query = entityManager.createNativeQuery("select count(*) from user u " +
        "where u.first_name like :firstName and u.last_name like :lastName and u.email like :email");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("email", email);
        return (!query.getSingleResult().equals(BigInteger.ZERO));
    }

}
