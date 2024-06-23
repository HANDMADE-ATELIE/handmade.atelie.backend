package com.handmade.atelie.backend.exceptions;

public class InvalidCpfCharException extends RuntimeException{
    public InvalidCpfCharException() {
        super("CPF must contain only numbers");
    }
}
