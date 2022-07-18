package com.tpavels.hibernate.entity.inheritance.one;

import javax.persistence.*;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false)
)
public class OneCreditCard extends OneBillingDetails {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    private Long id;

    private String number;
    private String expirationMonth;
    private String expirationYear;
}
