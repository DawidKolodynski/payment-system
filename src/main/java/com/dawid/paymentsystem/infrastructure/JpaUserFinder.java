package com.dawid.paymentsystem.infrastructure;

import com.dawid.paymentsystem.api.UserFinder;
import com.dawid.paymentsystem.api.dtos.UserDto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class JpaUserFinder implements UserFinder {

    private EntityManager entityManager;

    public JpaUserFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserDto> getAll() {
        Query query = entityManager.createQuery(
                "select new com.dawid.paymentsystem.api.dtos.UserDto(u.id, u.firstName, u.lastName, u.email, u.password, u.cards) from User u");
        return query.getResultList();
    }
}
