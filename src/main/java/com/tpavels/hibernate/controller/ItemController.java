package com.tpavels.hibernate.controller;

import com.tpavels.hibernate.entity.Item;
import com.tpavels.hibernate.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Item> getItem(@PathVariable String id) {
        var bid = itemService.getById(id);
        return ResponseEntity.ok(bid);
    }

    @PostMapping
    private ResponseEntity<Void> createItem(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.ok().build();
    }
}
