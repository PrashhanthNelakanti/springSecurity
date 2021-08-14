package com.prashhanth.secuirty;

import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DataJpaTest
public class UserServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepo userRepo;

    Optional<User> getUser(){
        Optional<User> optionalUser= Optional.of(new User());
        optionalUser.get().setRole("ROLE_USER");
        optionalUser.get().setPassword("mkal");
        optionalUser.get().setName("Oge");
        optionalUser.get().setUserId("User_00001");
        optionalUser.get().setActive(true);
        return optionalUser;
    }

    @Test
    void addUserTest(){
        User user=getUser().get();
        user.setUserId(null);
        assertThatNoException().isThrownBy(()->this.testEntityManager.persist(user));
    }

    @Test
    void findUserByNameTest(){
        userRepo.save(getUser().get());
        assertThat(userRepo.findByName(getUser().get().getName())).isEqualTo(getUser());
    }
}
