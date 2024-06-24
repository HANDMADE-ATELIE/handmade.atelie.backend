package com.handmade.atelie.backend.exceptions;

public class InvalidCpfException extends RuntimeException {

    public InvalidCpfException() {
        super("Invalid CPF");
    }

}
