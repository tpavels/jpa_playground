package com.tpavels.hibernate.service;

import com.tpavels.hibernate.entity.User;
import com.tpavels.hibernate.persistence.UserPersistenceService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserPersistenceService userPersistenceService;

    public UserService(UserPersistenceService userPersistenceService) {
        this.userPersistenceService = userPersistenceService;
    }

    public User getById(String id) {
        return userPersistenceService.getById(Long.valueOf(id));
    }

    public void save(User user) {
        userPersistenceService.persist(user);
    }
}
