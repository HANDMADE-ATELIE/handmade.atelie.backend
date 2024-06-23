package com.handmade.atelie.backend.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    
    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
    
}
