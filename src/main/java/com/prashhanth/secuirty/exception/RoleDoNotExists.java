package com.prashhanth.secuirty.exception;

public class RoleDoNotExists extends RuntimeException{
    public RoleDoNotExists(String message) {
        super(message);
    }
}
