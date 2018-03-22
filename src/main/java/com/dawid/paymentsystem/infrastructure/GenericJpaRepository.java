package com.dawid.paymentsystem.infrastructure;




import com.dawid.paymentsystem.model.repositories.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class GenericJpaRepository<T> implements Repository<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> tClass;

    GenericJpaRepository() {
        this.tClass = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public void save(T t) {
        entityManager.persist(t);
    }

    public T get(Long id) {
        T  t = entityManager.find(tClass, id);
        if (t == null)
            throw new NoSuchEntityException();
        return t;
    }
}
