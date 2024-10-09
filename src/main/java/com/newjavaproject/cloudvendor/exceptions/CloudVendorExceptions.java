package com.newjavaproject.cloudvendor.exceptions;

import org.springframework.http.HttpStatus;

public class CloudVendorExceptions {
    private final String message;
    private final Throwable cause;
    private final HttpStatus status;
    
    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public CloudVendorExceptions(String message, Throwable cause, HttpStatus status) {
        this.message = message;
        this.cause = cause;
        this.status = status;
    }
}
