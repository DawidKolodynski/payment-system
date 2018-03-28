package com.dawid.paymentsystem.infrastructure;

import com.dawid.paymentsystem.model.QUser;
import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.repositories.CardRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JpaCardRepository extends GenericJpaRepository<User> implements CardRepository {

    @Override
    public Set<User> getCards(Integer userId) {
        JPAQuery<User> query = new JPAQuery<>(entityManager);
        QUser qUser = QUser.user;
        List<User> results = query.from(qUser).where(qUser.id.eq(userId)).fetch();
        return new HashSet<>(results);
    }

    @Override
    public User get(Integer userId) {
        JPAQuery<User> query = new JPAQuery<>(entityManager);
        QUser user = QUser.user;

//        Query query = entityManager.createNativeQuery("SELECT u.cards FROM user_cards u " +
//                "where u.user_id = :userId");
//        query.setParameter("userId", userId);
        return  query.from(user).where(user.id.eq(userId)).fetchOne();
    }
}
