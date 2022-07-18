package com.tpavels.hibernate.persistence;

import com.tpavels.hibernate.entity.Bid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BidPersistenceService {

    @PersistenceContext
    private final EntityManager entityManager;

    public BidPersistenceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Bid getById(Long id) {
       return entityManager.find(Bid.class, id);
    }

    @Transactional
    public void persist(Bid bid) {
        entityManager.persist(bid);
    }

    @Transactional
    public void merge(Bid bid) {
        entityManager.merge(bid);
    }
}
