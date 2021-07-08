package com.prashhanth.secuirty.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hospitalcontroller {

    @Autowired
    HospitalService hospitalService;

    @PostMapping("/hosiptal")
    public String fixApp(@RequestBody HopitalDto hopitalDto){
        return hospitalService.registerPatient(hopitalDto);
    }
}
