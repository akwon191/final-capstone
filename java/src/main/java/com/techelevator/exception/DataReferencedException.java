package com.techelevator.exception;

public class DataReferencedException extends Exception{
    public DataReferencedException() { super(); }

    public DataReferencedException(String message) {
        super(message);
    }

    public DataReferencedException(String message, Exception cause) {
        super(message, cause);
    }
}


