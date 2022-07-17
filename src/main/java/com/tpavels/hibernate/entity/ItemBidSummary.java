package com.tpavels.hibernate.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(
        value = "SELECT i.id as ITEMID, i.NAME as NAME, " +
                "COUNT(b.id) as NUMOFBIDS " +
                "FROM item i LEFT OUTER JOIN bid b ON i.id = b.item_id " +
                "GROUP BY i.id, i.name "
)
@Synchronize({"Item", "Bid"}) // hiber will know to flush modification of tables before executing the query
public class ItemBidSummary {

    @Id
    private Long itemId;
    private String name;
    private long numOfBids;

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public long getNumOfBids() {
        return numOfBids;
    }
}
