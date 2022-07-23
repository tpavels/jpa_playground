package com.tpavels.hibernate.entity.inheritance.single;

import lombok.ToString;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
@ToString(callSuper = true)
public class SingleCreditCard extends SingleBillingDetails {

    @Column(nullable = true)
    private String number;
    @Column(nullable = true)
    private String expirationMonth;
    @Column(nullable = true)
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
