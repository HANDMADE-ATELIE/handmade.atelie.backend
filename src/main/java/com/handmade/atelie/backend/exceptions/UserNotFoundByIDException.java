package com.handmade.atelie.backend.exceptions;

public class UserNotFoundByIDException extends RuntimeException{
    public UserNotFoundByIDException(String id) {
        super("User not found with id: " + id);
    }
}
