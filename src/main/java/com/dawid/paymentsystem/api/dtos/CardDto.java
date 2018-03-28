package com.dawid.paymentsystem.api.dtos;

import com.dawid.paymentsystem.model.User;

import java.util.Set;

public class CardDto {

    private Integer id;

    private Set<User> cards;

    public CardDto(Integer id, Set<User> cards) {
        this.id = id;
        this.cards = cards;
    }

    public CardDto(Set<User> cards) {
        this.cards = cards;
    }
    
    

    public CardDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getCards() {
        return cards;
    }

    public void setCards(Set<User> cards) {
        this.cards = cards;
    }
}
