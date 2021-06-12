package com.prashhanth.secuirty.service;

import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.exception.UserAlreadyExits;
import com.prashhanth.secuirty.repo.user.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User addUser(User user){
        logger.info("Added user "+user);
        if(!getUserByName(user.getName()).isEmpty())
            throw new UserAlreadyExits("Check the your "+user.getName());
        String enCodedPwd=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(enCodedPwd);
        return userRepo.save(user);
    }

    public Optional<User> getUserByName(String name){
        return userRepo.findByName(name);
    }

    public Optional<User> getUserById(String id){
        logger.info("User id provided "+id);
        return userRepo.findById(id);
    }

    public List<User> getAllUsers(){
        logger.info("Users List "+userRepo.findAll());
        return userRepo.findAll();
    }


}
