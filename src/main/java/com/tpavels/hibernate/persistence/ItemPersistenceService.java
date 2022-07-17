package com.tpavels.hibernate.persistence;

import com.tpavels.hibernate.entity.Item;
import org.springframework.stereotype.Service;

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
}
