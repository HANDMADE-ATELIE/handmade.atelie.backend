package com.handmade.atelie.backend.exceptions;

public class InvalidStateException extends RuntimeException{
    
    public InvalidStateException() {
        super("Invalid state");
    }
    
}
