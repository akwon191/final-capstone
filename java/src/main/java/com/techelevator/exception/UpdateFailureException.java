package com.techelevator.exception;

public class UpdateFailureException extends Exception {

    public UpdateFailureException() { super();}

    public UpdateFailureException(String msg) {
        super(msg);
    }

    public UpdateFailureException(String msg, Exception cause) {
        super(msg, cause);
    }

}


