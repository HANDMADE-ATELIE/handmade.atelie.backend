package com.handmade.atelie.backend.exceptions;

public class InvalidPhoneNumberException extends RuntimeException{

    public InvalidPhoneNumberException() {
        super("Invalid phone number, must have only 10 or 11 numeric characters and no special characters");
    }

}
