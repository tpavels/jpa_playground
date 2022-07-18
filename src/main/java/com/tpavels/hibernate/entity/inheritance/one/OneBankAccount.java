package com.tpavels.hibernate.entity.inheritance.one;

import javax.persistence.*;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
public class OneBankAccount extends OneBillingDetails {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    private Long id;

    private String account;
    private String bankname;
    private String swift;
}
