package com.tpavels.hibernate.entity.inheritance.tableper;

import javax.persistence.Entity;

@Entity
public class TwoBankAccount extends TwoBillingDetails {

    private String account;
    private String bankname;
    private String swift;
}
