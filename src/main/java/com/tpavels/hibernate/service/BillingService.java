package com.tpavels.hibernate.service;

import com.tpavels.hibernate.entity.inheritance.join.JoinBankAccount;
import com.tpavels.hibernate.entity.inheritance.join.JoinBillingDetails;
import com.tpavels.hibernate.entity.inheritance.join.JoinCreditCard;
import com.tpavels.hibernate.entity.inheritance.mappedsuper.OneBankAccount;
import com.tpavels.hibernate.entity.inheritance.mappedsuper.OneCreditCard;
import com.tpavels.hibernate.entity.inheritance.single.SingleBankAccount;
import com.tpavels.hibernate.entity.inheritance.single.SingleBillingDetails;
import com.tpavels.hibernate.entity.inheritance.single.SingleCreditCard;
import com.tpavels.hibernate.entity.inheritance.tableper.TwoBankAccount;
import com.tpavels.hibernate.entity.inheritance.tableper.TwoBillingDetails;
import com.tpavels.hibernate.entity.inheritance.tableper.TwoCreditCard;
import com.tpavels.hibernate.persistence.BillingPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingService {

    private final BillingPersistenceService billingPersistenceService;

    public BillingService(BillingPersistenceService billingPersistenceService) {
        this.billingPersistenceService = billingPersistenceService;
    }

    public void create() {
        createCC();
        createBA();
    }

    private void createBA() {
        var oneBankAccount = new OneBankAccount();
        oneBankAccount.setAccount("IBAN123");
        billingPersistenceService.create(oneBankAccount);
        log.info("oneBankAccount created ID = {}", oneBankAccount.getId());

        var twoBankAccount = new TwoBankAccount();
        twoBankAccount.setAccount("IBAN123");
        billingPersistenceService.create(twoBankAccount);
        log.info("twoBankAccount created ID = {}", twoBankAccount.getId());

        var singleBankAccount = new SingleBankAccount();
        singleBankAccount.setAccount("IBAN123");
        billingPersistenceService.create(singleBankAccount);
        log.info("singleBankAccount created ID = {}", singleBankAccount.getId());

        var joinBankAccount = new JoinBankAccount();
        joinBankAccount.setAccount("IBAN123");
        billingPersistenceService.create(joinBankAccount);
        log.info("joinBankAccount created ID = {}", joinBankAccount.getId());
    }

    private void createCC() {
        OneCreditCard oneCreditCard = new OneCreditCard();
        oneCreditCard.setExpirationMonth("1");
        oneCreditCard.setExpirationYear("2");
        oneCreditCard.setNumber("11232323 132 ");
        oneCreditCard.setOwner("owner");
        billingPersistenceService.create(oneCreditCard);
        /*
Hibernate: call next value for tpavels_seq
Hibernate: insert into one_credit_card (cc_owner, expiration_month, expiration_year, number, id) values (?, ?, ?, ?, ?)
        */
        log.info("OneCreditCard created ID = {}", oneCreditCard.getId());

        TwoCreditCard twoCreditCard = new TwoCreditCard();
        twoCreditCard.setExpirationMonth("1");
        twoCreditCard.setExpirationYear("2");
        twoCreditCard.setNumber("11232323 132 ");
        twoCreditCard.setOwner("owner");
        billingPersistenceService.create(twoCreditCard);
        /*
Hibernate: call next value for tpavels_seq
Hibernate: insert into two_credit_card (owner, expiration_month, expiration_year, number, id) values (?, ?, ?, ?, ?)
        */
        log.info("TwoCreditCard created ID = {}", twoCreditCard.getId());

        SingleCreditCard singleCreditCard = new SingleCreditCard();
        singleCreditCard.setExpirationMonth("1");
        singleCreditCard.setExpirationYear("2");
        singleCreditCard.setNumber("11232323 132 ");
        singleCreditCard.setOwner("owner");
        billingPersistenceService.create(singleCreditCard);
        /*
Hibernate: call next value for tpavels_seq
Hibernate: insert into three_billing_details (owner, expiration_month, expiration_year, number, bd_type, id) values (?, ?, ?, ?, 'CC', ?)
        */
        log.info("singleCreditCard created ID = {}", singleCreditCard.getId());

        JoinCreditCard joinCreditCard = new JoinCreditCard();
        joinCreditCard.setExpirationMonth("1");
        joinCreditCard.setExpirationYear("2");
        joinCreditCard.setNumber("11232323 132 ");
        joinCreditCard.setOwner("owner");
        billingPersistenceService.create(joinCreditCard);
        /*
Hibernate: call next value for tpavels_seq
Hibernate: insert into join_billing_details (owner, id) values (?, ?)
Hibernate: insert into join_credit_card (expiration_month, expiration_year, number, credit_id) values (?, ?, ?, ?)
        */
        log.info("JoinCreditCard created ID = {}", joinCreditCard.getId());
    }

    public void get() {
        var id = 100L;
        var oneCreditCard = billingPersistenceService.get(id, OneCreditCard.class);
        /*
        Hibernate: select
       [...]
        from one_credit_card onecreditc0_ where onecreditc0_.id=?
         */
        log.info("Loaded: {}", oneCreditCard.toString());

        var twoCreditCard = billingPersistenceService.get(id + 1, TwoCreditCard.class);
        /*
        Hibernate: [...]
          from two_credit_card twocreditc0_
        where twocreditc0_.id=?
         */
        log.info("Loaded: {}", twoCreditCard.toString());

        var singleCreditCard = billingPersistenceService.get(id + 2, SingleCreditCard.class);
        /*
        Hibernate: select [...]
             from three_billing_details threecredi0_
             where threecredi0_.id=? and threecredi0_.bd_type='CC'
         */
        log.info("Loaded: {}", singleCreditCard.toString());

        var joinCreditCard = billingPersistenceService.get(id + 3, JoinCreditCard.class);
        /*
        Hibernate: select [...]
         from join_credit_card joincredit0_
          inner join join_billing_details joincredit0_1_ on joincredit0_.credit_id=joincredit0_1_.id
         where joincredit0_.credit_id=?
         */
        log.info("Loaded: {}", joinCreditCard.toString());
    }

    public void getSuper() {
        var id = 100L;
//        var oneBillingDetails = billingPersistenceService.get(id, OneBillingDetails.class); //cant error.

        var twoBillingDetails = billingPersistenceService.get(id + 1, TwoBillingDetails.class);
        /*
Hibernate: select twobilling0_.id as id1_9_0_, twobilling0_.owner as owner2_9_0_,
twobilling0_.account as account1_8_0_, twobilling0_.bankname as bankname2_8_0_,
twobilling0_.swift as swift3_8_0_, twobilling0_.expiration_month as expirati1_10_0_,
 twobilling0_.expiration_year as expirati2_10_0_, twobilling0_.number as number3_10_0_,
  twobilling0_.clazz_ as clazz_0_
   from
   ( select id, owner, account, bankname, swift,
    null as expiration_month, null as expiration_year, null as number, 1 as clazz_
   from two_bank_account
   union all
   select id, owner, null as account, null as bankname, null as swift,
    expiration_month, expiration_year, number, 2 as clazz_ from two_credit_card
    ) twobilling0_
     where twobilling0_.id=?
         */
        log.info("Loaded: {}", twoBillingDetails.toString());

        var singleBillingDetails = billingPersistenceService.get(id + 2, SingleBillingDetails.class);
        /*
        Hibernate: select
        singlebill0_.id as id2_7_0_, singlebill0_.owner as owner3_7_0_,
         singlebill0_.account as account4_7_0_,
         singlebill0_.bankname as bankname5_7_0_,
          singlebill0_.swift as swift6_7_0_,
           singlebill0_.expiration_month as expirati7_7_0_,
            singlebill0_.expiration_year as expirati8_7_0_,
            singlebill0_.number as number9_7_0_,
            singlebill0_.bd_type as bd_type1_7_0_
            from single_billing_details singlebill0_
             where singlebill0_.id=?
         */
        log.info("Loaded: {}", singleBillingDetails.toString());

        var joinBillingDetails = billingPersistenceService.get(id + 3, JoinBillingDetails.class);
        /*
       Hibernate: select
       joinbillin0_.id as id1_3_0_, joinbillin0_.owner as owner2_3_0_,
        joinbillin0_1_.account as account1_2_0_, joinbillin0_1_.bankname as bankname2_2_0_,
        joinbillin0_1_.swift as swift3_2_0_, joinbillin0_2_.expiration_month as expirati1_4_0_,
         joinbillin0_2_.expiration_year as expirati2_4_0_, joinbillin0_2_.number as number3_4_0_,
         case
         when joinbillin0_1_.id is not null then 1
         when joinbillin0_2_.credit_id is not null then 2
         when joinbillin0_.id is not null then 0
         end as clazz_0_
         from join_billing_details joinbillin0_
         left outer join join_bank_account joinbillin0_1_ on joinbillin0_.id=joinbillin0_1_.id
         left outer join join_credit_card joinbillin0_2_ on joinbillin0_.id=joinbillin0_2_.credit_id
         where joinbillin0_.id=?
         */
        log.info("Loaded: {}", joinBillingDetails.toString());
    }
}
