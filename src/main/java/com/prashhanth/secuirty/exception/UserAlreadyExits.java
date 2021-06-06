package com.prashhanth.secuirty.exception;

public class UserAlreadyExits extends RuntimeException {

    public UserAlreadyExits(String message) {
        super(message);
    }
}
