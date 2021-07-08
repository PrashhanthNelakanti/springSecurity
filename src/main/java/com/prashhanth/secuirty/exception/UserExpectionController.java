package com.prashhanth.secuirty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExpectionController {

    @ExceptionHandler(value = UserAlreadyExits.class)
    public ResponseEntity<Object> exception(UserAlreadyExits exception) {
        return new ResponseEntity<>("User Alredy exits "+exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RoleDoNotExists.class)
    public ResponseEntity<Object> exception(RoleDoNotExists exception) {
        return new ResponseEntity<>("Please check the role "+exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
