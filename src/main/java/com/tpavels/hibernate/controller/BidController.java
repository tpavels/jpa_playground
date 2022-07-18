package com.tpavels.hibernate.controller;

import com.tpavels.hibernate.entity.Bid;
import com.tpavels.hibernate.service.BidService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bids")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Bid> getBid(@PathVariable String id) {
        var bid = bidService.getById(id);
        return ResponseEntity.ok(bid);
    }

    @PostMapping
    private ResponseEntity<Void> createBid(@RequestBody Bid bid) {
        bidService.save(bid);
        return ResponseEntity.ok().build();
    }
}
