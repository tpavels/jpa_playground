package com.tpavels.hibernate.entity.inheritance.tableper;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString(callSuper = true)
public class TwoBankAccount extends TwoBillingDetails {

    @Setter
    private String account;
    @Setter
    private String bankname;
    @Setter
    private String swift;
}
