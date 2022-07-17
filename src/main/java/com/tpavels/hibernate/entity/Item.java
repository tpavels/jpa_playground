package com.tpavels.hibernate.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
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

    public Long getId() { //not needed for hibernate
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.startsWith("LOT: ") ? name : "LOT: " + name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
}
