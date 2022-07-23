package com.tpavels.hibernate.controller;

import com.tpavels.hibernate.service.BillingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billings")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PutMapping
    public void createBilling() {
        billingService.create();
    }

    @GetMapping
    public void getBillings() {
//        billingService.get();
        billingService.getSuper();
    }
}
