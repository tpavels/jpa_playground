package com.tpavels.hibernate.controller;

import com.tpavels.hibernate.entity.inheritance.join.JoinCreditCard;
import com.tpavels.hibernate.entity.inheritance.mappedsuper.OneCreditCard;
import com.tpavels.hibernate.entity.inheritance.single.ThreeCreditCard;
import com.tpavels.hibernate.entity.inheritance.tableper.TwoCreditCard;
import com.tpavels.hibernate.persistence.BillingPersistenceService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billings")
public class BillingController {

    private final BillingPersistenceService billingPersistenceService;

    public BillingController(BillingPersistenceService billingPersistenceService) {
        this.billingPersistenceService = billingPersistenceService;
    }

    @PutMapping
    public void createBilling() {

        OneCreditCard oneCreditCard = new OneCreditCard();
        oneCreditCard.setExpirationMonth("1");
        oneCreditCard.setExpirationYear("2");
        oneCreditCard.setNumber("11232323 132 ");
        oneCreditCard.setOwner("owner");
        billingPersistenceService.createOne(oneCreditCard);

        TwoCreditCard twoCreditCard = new TwoCreditCard();
        twoCreditCard.setExpirationMonth("1");
        twoCreditCard.setExpirationYear("2");
        twoCreditCard.setNumber("11232323 132 ");
        twoCreditCard.setOwner("owner");
        billingPersistenceService.createTwo(twoCreditCard);

        ThreeCreditCard threeCreditCard = new ThreeCreditCard();
        threeCreditCard.setExpirationMonth("1");
        threeCreditCard.setExpirationYear("2");
        threeCreditCard.setNumber("11232323 132 ");
        threeCreditCard.setOwner("owner");
        billingPersistenceService.createThree(threeCreditCard);

        JoinCreditCard joinCreditCard = new JoinCreditCard();
        joinCreditCard.setExpirationMonth("1");
        joinCreditCard.setExpirationYear("2");
        joinCreditCard.setNumber("11232323 132 ");
        joinCreditCard.setOwner("owner");
        billingPersistenceService.createJoin(joinCreditCard);
    }
}
