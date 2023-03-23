package com.example.rewardsrestfulapi.rest;

import com.example.rewardsrestfulapi.exception.CustomerExistsException;
import com.example.rewardsrestfulapi.exception.CustomerNotFoundException;
import com.example.rewardsrestfulapi.exception.DBOpreationException;
import com.example.rewardsrestfulapi.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerCustomerNotExists(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerExistsException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerCustomerExistsException(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DBOpreationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerDatabaseOperationFailure(Exception exc) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
