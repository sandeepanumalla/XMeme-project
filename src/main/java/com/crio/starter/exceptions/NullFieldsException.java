package com.crio.starter.exceptions;

public class NullFieldsException extends Exception {
    public NullFieldsException(String message){
        super(message);
    }

    public NullFieldsException(String message, Throwable cause){
        super(message, cause);
    }
}
