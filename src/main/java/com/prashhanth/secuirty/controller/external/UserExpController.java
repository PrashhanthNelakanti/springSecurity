package com.prashhanth.secuirty.controller.external;

import com.prashhanth.secuirty.service.external.UserExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserExpController {

    @Autowired
    UserExtService userExtService;

    @GetMapping("/ext/user")
    public ResponseEntity<?> getUserList(){
        return userExtService.getUsersList();
    }
}
