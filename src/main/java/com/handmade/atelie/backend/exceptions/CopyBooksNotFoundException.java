package com.handmade.atelie.backend.exceptions;

public class CopyBooksNotFoundException extends RuntimeException {
    public CopyBooksNotFoundException() {
        super("No products were found");
    }

}
