package com.tpavels.hibernate.persistence;

import com.tpavels.hibernate.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ItemPersistenceService {

    @PersistenceContext
    private final EntityManager entityManager;

    public ItemPersistenceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Item getById(Long id) {
        return entityManager.find(Item.class, id);
    }

    @Transactional
    public void persist(Item item) {
        entityManager.persist(item);
    }

    @Transactional
    public void merge(Item item) {
        entityManager.merge(item);
    }
}
