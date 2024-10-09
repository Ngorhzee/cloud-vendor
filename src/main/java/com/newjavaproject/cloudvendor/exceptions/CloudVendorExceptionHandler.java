package com.newjavaproject.cloudvendor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendorNotFound.class})
    public  ResponseEntity<Object> handleNotFoundException(CloudVendorNotFound cloudVendorNotFound){
            CloudVendorExceptions cloudVendorExceptions = new CloudVendorExceptions(
                cloudVendorNotFound.getMessage(),
                cloudVendorNotFound.getCause(),
                HttpStatus.NOT_FOUND
            );

            return new ResponseEntity<>(cloudVendorExceptions, HttpStatus.NOT_FOUND);
    }
    
}
