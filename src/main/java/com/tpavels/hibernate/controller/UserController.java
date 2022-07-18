package com.tpavels.hibernate.controller;

import com.tpavels.hibernate.entity.User;
import com.tpavels.hibernate.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<User> getUSer(@PathVariable String id) {
        var bid = userService.getById(id);
        return ResponseEntity.ok(bid);
    }

    @PostMapping
    private ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
