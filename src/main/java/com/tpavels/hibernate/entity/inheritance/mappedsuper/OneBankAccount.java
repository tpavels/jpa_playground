package com.tpavels.hibernate.entity.inheritance.mappedsuper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
@ToString(callSuper = true)
public class OneBankAccount extends OneBillingDetails {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    @Getter
    private Long id;

    @Setter
    private String account;
    @Setter
    private String bankname;
    @Setter
    private String swift;
}
