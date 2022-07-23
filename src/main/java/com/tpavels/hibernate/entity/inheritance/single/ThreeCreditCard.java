package com.tpavels.hibernate.entity.inheritance.single;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class ThreeCreditCard extends ThreeBillingDetails {

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
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
