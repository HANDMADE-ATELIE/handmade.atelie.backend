package com.handmade.atelie.backend.exceptions;

public class InvalidEmailFormatException extends RuntimeException {
    
    public InvalidEmailFormatException() {
        super("Invalid email format");
    }

}
