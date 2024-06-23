package com.handmade.atelie.backend.exceptions;

public class JWTCreationErrorException extends RuntimeException {
    
    public JWTCreationErrorException() {
        super("Error while creating token");
    }
    
}
