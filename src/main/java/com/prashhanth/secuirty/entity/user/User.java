package com.prashhanth.secuirty.entity.user;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String name;
    private String password;
    private String role;
    private boolean isActive;


}
