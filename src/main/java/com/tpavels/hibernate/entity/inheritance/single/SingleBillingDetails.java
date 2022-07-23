package com.tpavels.hibernate.entity.inheritance.single;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
@ToString
public abstract class SingleBillingDetails {

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
