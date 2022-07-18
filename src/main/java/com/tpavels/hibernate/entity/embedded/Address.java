package com.tpavels.hibernate.entity.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

// value type
@Embeddable
public class Address {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "CITY", nullable = false))
    })
    private City city;

    public Address() {
    }
}
