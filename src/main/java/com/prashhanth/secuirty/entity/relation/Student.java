package com.prashhanth.secuirty.entity.relation;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer stId;
    private String sname;
    private String city;
    @OneToMany(targetEntity = Laptop.class,cascade = CascadeType.ALL)
    @JoinColumn(name="sl_fk",referencedColumnName = "stId")
    private List<Laptop> laptop;
}
