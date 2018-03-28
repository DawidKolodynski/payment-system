package com.dawid.paymentsystem.api;

import com.dawid.paymentsystem.api.dtos.CardDto;

import java.util.List;

public interface CardFinder {

    List<CardDto> getCards(Integer userId);
}
