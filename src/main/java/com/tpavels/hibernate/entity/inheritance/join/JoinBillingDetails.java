package com.tpavels.hibernate.entity.inheritance.join;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public abstract class JoinBillingDetails {

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
