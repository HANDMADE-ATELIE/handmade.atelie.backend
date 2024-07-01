package com.handmade.atelie.backend.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("Password must have at least 8 characters");
    }
}
