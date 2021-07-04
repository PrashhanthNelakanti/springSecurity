package com.prashhanth.secuirty.entity.relation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Laptop {

    @Id
    private Integer lapId;
    private String lname;
}
