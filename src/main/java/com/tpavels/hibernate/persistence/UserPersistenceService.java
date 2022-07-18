package com.tpavels.hibernate.persistence;

import com.tpavels.hibernate.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserPersistenceService {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserPersistenceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void merge(User user) {
        entityManager.merge(user);
    }


}
