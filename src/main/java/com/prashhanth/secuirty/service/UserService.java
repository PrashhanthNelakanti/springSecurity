package com.prashhanth.secuirty.service;

import com.prashhanth.secuirty.controller.UserController;
import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.exception.RoleDoNotExists;
import com.prashhanth.secuirty.exception.UserAlreadyExits;
import com.prashhanth.secuirty.repo.RolesRepository;
import com.prashhanth.secuirty.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> addUser(User user){
        logger.info("Adding user "+user);
        if(getUserByName(user.getName()).isPresent()) {
            throw new UserAlreadyExits("Check the user "+user.getName());
        }
        String roles = Arrays.stream(user.getRole().split(",")).
                filter(u->checkUserExists(u))
                .map(x -> "ROLE_" + x).
                collect(Collectors.joining(","));
        user.setRole(roles);
        String enCodedPwd=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(enCodedPwd);
        logger.info("Added user "+user);
        User userObj = userRepo.save(user);
        user.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
    }

    public boolean checkUserExists(String role){
        if(rolesRepository.findByRoleName(role).isPresent())
            return true;
        else
            throw new RoleDoNotExists(role);
    }

    public Optional<User> getUserByName(String name){
        return userRepo.findByName(name);
    }

    public Optional<User> getUserById(String id){
        logger.info("User id provided "+id);
        return userRepo.findById(id);
    }

    public ResponseEntity<List<User>> getAllUsers(){
        logger.info("Users List "+userRepo.findAll());
        List<User> all = userRepo.findAll();
        List<User> userUp = new ArrayList();

        for (User user:
             all) {
            user.add(linkTo(methodOn(UserController.class).getUserById(user.getUserId())).withSelfRel());
            userUp.add(user);
        }
        return new ResponseEntity(userUp,HttpStatus.OK);
    }




}
