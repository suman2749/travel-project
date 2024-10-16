package com.hotel.exception;

import com.hotel.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorDetails>userExists(UserExistsException uee){
        ErrorDetails erd = new ErrorDetails(uee.getMessage(),new Date());
        return new ResponseEntity<>(erd, HttpStatus.NOT_FOUND);
    }
}
