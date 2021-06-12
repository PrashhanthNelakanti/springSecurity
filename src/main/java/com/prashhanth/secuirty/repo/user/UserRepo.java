package com.prashhanth.secuirty.repo.user;

import com.prashhanth.secuirty.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public Optional<User> findByName(String userName);
}
