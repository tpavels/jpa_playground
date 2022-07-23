package com.tpavels.hibernate.entity.inheritance.mappedsuper;

import lombok.ToString;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@ToString
public abstract class OneBillingDetails {

    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
