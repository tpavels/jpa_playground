package com.tpavels.hibernate.entity.inheritance.join;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
@ToString(callSuper = true)
public class JoinBankAccount extends JoinBillingDetails {

    @Setter
    private String account;
    @Setter
    private String bankname;
    @Setter
    private String swift;
}
