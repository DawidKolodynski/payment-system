package com.dawid.paymentsystem.model.repositories;

public interface Repository<T> {

    void save(T t);

    T get(Long id);
}
