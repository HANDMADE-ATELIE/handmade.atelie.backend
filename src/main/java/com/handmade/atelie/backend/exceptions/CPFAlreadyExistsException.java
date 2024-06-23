package com.handmade.atelie.backend.exceptions;

public class CPFAlreadyExistsException extends RuntimeException{
        
    public CPFAlreadyExistsException() {
        super("CPF already exists");
    }
    
}
