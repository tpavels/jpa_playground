package com.tpavels.hibernate.service;

import com.tpavels.hibernate.entity.Bid;
import com.tpavels.hibernate.persistence.BidPersistenceService;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    private final BidPersistenceService bidPersistenceService;

    public BidService(BidPersistenceService bidPersistenceService) {
        this.bidPersistenceService = bidPersistenceService;
    }

    public Bid getById(String id) {
        return bidPersistenceService.getById(Long.valueOf(id));
    }

    public void save(Bid bid) {
        bidPersistenceService.persist(bid);
    }
}
