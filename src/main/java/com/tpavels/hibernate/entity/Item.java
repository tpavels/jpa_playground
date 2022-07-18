package com.tpavels.hibernate.entity;

import com.tpavels.hibernate.entity.other.AuctionType;
import org.hibernate.annotations.*;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DynamicInsert //gen insert when needed, not upfront
@DynamicUpdate //gen update when needed, not upfront
public class Item {

    public static final String ID_GENERATOR = "ID_GENERATOR";

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    private Long id;

    @Access(AccessType.PROPERTY)
    @Column(name = "ITM_NAME")
    private String name;

    @Column(name = "BUYNOW_PRICE", nullable = false)
    private BigDecimal buyNowPrice;

    @Column(name = "INIT_PRICE", nullable = false)
    private BigDecimal initialPrice;

    @Enumerated(EnumType.STRING)
    private AuctionType auctionType = AuctionType.HIGHEST;

    @Type(type = "org.hibernate.type.YesNoType")
    private boolean verified;

    //    @Temporal(TemporalType.TIMESTAMP) //defaulted by hiber but required by JPA
    @Column(insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedDate;

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Item() {
    }

    public Long getId() { //not needed for hibernate
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.startsWith("LOT: ") ? name : "LOT: " + name;
    }
}
