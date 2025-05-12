package com.hussain.exception;

//public class InvalidRequestException {
//	
//	
//
//}


public class InvalidRequestException extends RuntimeException {
    private final String errorCode;

    public InvalidRequestException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}