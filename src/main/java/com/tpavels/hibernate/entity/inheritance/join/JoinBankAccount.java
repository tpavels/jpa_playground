package com.tpavels.hibernate.entity.inheritance.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class JoinBankAccount extends JoinBillingDetails {

    private String account;
    private String bankname;
    private String swift;
}
