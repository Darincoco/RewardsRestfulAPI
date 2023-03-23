package com.example.rewardsrestfulapi.exception;

public class DBOpreationException extends RuntimeException{
    private String errorMessage;

    public DBOpreationException() {
        super();
    }

    public DBOpreationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return errorMessage;
    }
}
