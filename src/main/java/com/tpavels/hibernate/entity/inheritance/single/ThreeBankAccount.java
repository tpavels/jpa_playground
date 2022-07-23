package com.tpavels.hibernate.entity.inheritance.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class ThreeBankAccount extends ThreeBillingDetails {

    private String account;
    private String bankname;
    private String swift;
}
