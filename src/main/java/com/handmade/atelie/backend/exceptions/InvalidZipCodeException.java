package com.handmade.atelie.backend.exceptions;

public class InvalidZipCodeException extends RuntimeException{

    public InvalidZipCodeException() {
        super("Invalid zip code");
    }
    
}
