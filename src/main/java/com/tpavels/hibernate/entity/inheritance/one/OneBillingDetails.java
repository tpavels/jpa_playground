package com.tpavels.hibernate.entity.inheritance.one;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OneBillingDetails {

    private String owner;
}
