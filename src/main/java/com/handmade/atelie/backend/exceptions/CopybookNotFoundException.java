package com.handmade.atelie.backend.exceptions;

public class CopybookNotFoundException extends RuntimeException {
    public CopybookNotFoundException() {
        super("Copybook not found");
    }
}
