package com.handmade.atelie.backend.exceptions;

public class UserNotFoundByEmailException extends RuntimeException{
    public UserNotFoundByEmailException(String email){
        super("User not found by email: " + email);
    }
}
