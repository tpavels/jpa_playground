package com.tpavels.hibernate.entity.inheritance.mappedsuper;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false)
)
@ToString(callSuper = true)
public class OneCreditCard extends OneBillingDetails {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    @Getter
    private Long id;

    private String number;
    @Column(nullable = true)
    private String expirationMonth;
    @Column(nullable = false)
    private String expirationYear;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}
