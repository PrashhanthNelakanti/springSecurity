package com.prashhanth.secuirty.entity.relation;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String laptop;

    public Inventory(String username, String laptop) {
        this.username = username;
        this.laptop = laptop;
    }
}
