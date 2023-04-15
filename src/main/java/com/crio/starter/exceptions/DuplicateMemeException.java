package com.crio.starter.exceptions;

public class DuplicateMemeException extends Exception {

    public DuplicateMemeException(String message) {
        super(message);
    }

    public DuplicateMemeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
