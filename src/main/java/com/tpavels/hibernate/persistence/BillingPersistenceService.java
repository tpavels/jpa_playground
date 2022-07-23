package com.tpavels.hibernate.persistence;

import com.tpavels.hibernate.entity.inheritance.join.JoinBillingDetails;
import com.tpavels.hibernate.entity.inheritance.mappedsuper.OneBillingDetails;
import com.tpavels.hibernate.entity.inheritance.mappedsuper.OneCreditCard;
import com.tpavels.hibernate.entity.inheritance.single.ThreeBillingDetails;
import com.tpavels.hibernate.entity.inheritance.tableper.TwoBillingDetails;
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

    @Transactional
    public <T extends OneBillingDetails> void createOne(T bd) {
        entityManager.persist(bd);
    }

    @Transactional
    public <T extends TwoBillingDetails> void createTwo(T bd) {
        entityManager.persist(bd);
    }

    @Transactional
    public <T extends ThreeBillingDetails> void createThree(T bd) {
        entityManager.persist(bd);
    }

    @Transactional
    public <T extends JoinBillingDetails> void createJoin(T bd) {
        entityManager.persist(bd);
    }
}
