package com.tpavels.hibernate.service;

import com.tpavels.hibernate.entity.Item;
import com.tpavels.hibernate.persistence.ItemPersistenceService;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemPersistenceService itemPersistenceService;

    public ItemService(ItemPersistenceService itemPersistenceService) {
        this.itemPersistenceService = itemPersistenceService;
    }

    public Item getById(String id) {
        return itemPersistenceService.getById(Long.valueOf(id));
    }

    public void save(Item item) {
     itemPersistenceService.persist(item);
    }
}
