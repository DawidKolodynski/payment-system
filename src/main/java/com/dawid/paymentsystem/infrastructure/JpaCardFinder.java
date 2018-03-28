package com.dawid.paymentsystem.infrastructure;

import com.dawid.paymentsystem.api.CardFinder;
import com.dawid.paymentsystem.api.dtos.CardDto;
import com.dawid.paymentsystem.model.QUser;
import com.dawid.paymentsystem.model.repositories.CardRepository;
import com.dawid.paymentsystem.model.repositories.UserRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class JpaCardFinder implements CardFinder {

    private EntityManager entityManager;

    private CardRepository cardRepository;

    private UserRepository userRepository;

    public JpaCardFinder(EntityManager entityManager, CardRepository cardRepository, UserRepository userRepository) {
        this.entityManager = entityManager;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CardDto> getCards(Integer userId) {

        JPAQuery<CardDto> query = new JPAQuery<>(entityManager);
        QUser user = QUser.user;
        query = query.from(user).where(user.id.in(userId));

        return query.fetch();


//        cardRepository.getCards(userId);
//        Set<User> cards = cardRepository.getCards(userId);
//        CardDto dto = new CardDto(cards);
//        return ArrayList<CardDto>(cards);

//        Query query = entityManager.createQuery(
//                "select new com.dawid.paymentsystem.api.dtos.CardDto(u.id, u.cards) from User u");
//        return query.getResultList();
    }
}
