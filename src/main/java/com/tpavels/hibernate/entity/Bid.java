package com.tpavels.hibernate.entity;

import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
@Immutable
public class Bid {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    private Long id;

    private Long amount;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedDate;

//    @Temporal(TemporalType.TIMESTAMP)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
