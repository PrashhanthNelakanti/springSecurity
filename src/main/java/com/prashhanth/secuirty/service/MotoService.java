package com.prashhanth.secuirty.service;

import com.prashhanth.secuirty.entity.moto.Motor;
import com.prashhanth.secuirty.repo.moto.MotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {

    @Autowired
    private MotoRepo motoRepo;


    public Motor saveMoto(){
        Motor motor= new Motor();
        motor.setMid(46545);
        motor.setMname("Fiat");
        return motoRepo.save(motor);
    }
}
