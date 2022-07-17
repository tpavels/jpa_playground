package com.tpavels.hibernate.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Immutable
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(insertable = false)
    @ColumnDefault("1.00")
    @Generated(GenerationTime.INSERT)
    private BigDecimal initPrice;

    public Bid() {
    }

    public Bid(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

}
