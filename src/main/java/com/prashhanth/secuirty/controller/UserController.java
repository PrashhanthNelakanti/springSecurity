package com.prashhanth.secuirty.controller;

import com.prashhanth.secuirty.entity.User;
import com.prashhanth.secuirty.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @PostMapping("/")
    public User addDefaults(@RequestBody User user){
        logger.info("User added from Controller "+user);
        return service.addUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id){
        logger.info("Id passed to Controller "+id);
        return service.getUserById(id);
    }

    @GetMapping("/admin")
    public List<User> getAllUsers(){
        logger.info("Find All Users");
        return service.getAllUsers();
    }

}
