package com.handmade.atelie.backend.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
        
    public EmailAlreadyExistsException() {
        super("Email already exists");
    }

}
