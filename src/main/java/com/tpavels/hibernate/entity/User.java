package com.tpavels.hibernate.entity;

import com.tpavels.hibernate.entity.embedded.Address;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.tpavels.hibernate.entity.Item.ID_GENERATOR;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    private Long id;

    @Embedded
    private Address orderAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "B_STREET")),
            @AttributeOverride(name = "city.name", column = @Column(name = "B_CITY")),
            @AttributeOverride(name = "city.country", column = @Column(name = "B_COUNTRY")),
            @AttributeOverride(name = "city.zipCode", column = @Column(name = "B_ZIP_CODE"))
    })
    private Address billingAddress;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
