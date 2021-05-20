package com.prashhanth.secuirty.service;

import com.prashhanth.secuirty.entity.User;
import com.prashhanth.secuirty.repo.UserRepo;
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
        String enCodedPwd=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(enCodedPwd);
        return userRepo.save(user);
    }

    public Optional<User> getUserById(Integer id){
        logger.info("User id provided "+id);
        return userRepo.findById(id);
    }

    public List<User> getAllUsers(){
        logger.info("Users List "+userRepo.findAll());
        return userRepo.findAll();
    }

}
