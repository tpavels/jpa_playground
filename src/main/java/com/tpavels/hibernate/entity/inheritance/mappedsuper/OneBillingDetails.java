package com.tpavels.hibernate.entity.inheritance.mappedsuper;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OneBillingDetails {

    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
