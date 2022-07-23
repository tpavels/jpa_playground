package com.tpavels.hibernate.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BillingPersistenceService {

    @PersistenceContext
    private final EntityManager entityManager;

    public BillingPersistenceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <T> T get(Long id, Class<T> clazz) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    public <T> void create(T bd) {
        entityManager.persist(bd);
    }

}
