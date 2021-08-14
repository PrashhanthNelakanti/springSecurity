package com.prashhanth.secuirty.repo;


import com.prashhanth.secuirty.entity.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public Optional<User> findByName(String userName);

    //here this meth is returning custom obj from existing entity

}
