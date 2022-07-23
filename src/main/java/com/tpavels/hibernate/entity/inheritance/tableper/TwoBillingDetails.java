package com.tpavels.hibernate.entity.inheritance.tableper;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public abstract class TwoBillingDetails {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    @Getter
    private Long id;

    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
