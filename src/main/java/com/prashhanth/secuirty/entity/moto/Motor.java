package com.prashhanth.secuirty.entity.moto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Motor {

    @Id
    private Integer mid;
    private String mname;
}
