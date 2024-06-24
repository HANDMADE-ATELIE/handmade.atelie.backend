package com.handmade.atelie.backend.exceptions;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException() {
        super("Invalid age, must be over 18 years old");
    }
}
