package com.hussain.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hussain.dto.ErrorResponse;




//@ControllerAdvice
//public class GlobalExceptionHandler {
//
////	@ExceptionHandler(NullPointerException.class)
////	public ResponseEntity<?> handleNullPointerException(Exception e) {
////
////		ErrorResponse error = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
////				.message("You doing operation with Null value").build();
////		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
////	}
//	
//	
//	 @ExceptionHandler(NullPointerException.class)
//	    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
//	        String fieldName = extractFieldNameFromNPE(ex);
//	        String errorCode = "ERR_NULL_" + fieldName.toUpperCase();
//	        
//	        ErrorResponse error = new ErrorResponse(
//	            HttpStatus.BAD_REQUEST.value(),
//	            errorCode,
//	            "Required field '" + fieldName + "' cannot be null"
//	        );
//	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	    }
//
//	    @ExceptionHandler(InvalidRequestException.class)
//	    public ResponseEntity<ErrorResponse> handleInvalidRequest(InvalidRequestException ex) {
//	        ErrorResponse error = new ErrorResponse(
//	            HttpStatus.BAD_REQUEST.value(),
//	            ex.getErrorCode(),
//	            ex.getMessage()
//	        );
//	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	    }
//
//	    private String extractFieldNameFromNPE(NullPointerException ex) {
//	        // Parse exception message to extract field name
//	        String msg = ex.getMessage();
//	        if (msg != null && msg.contains("\"")) {
//	            return msg.split("\"")[1];
//	        }
//	        return "FIELD";
//	    }
//	    
//	    
//	    
////	@ExceptionHandler(MissingServletRequestParameterException.class)
////	public ResponseEntity<?> handleMissingParameterException(Exception e) {
////
////		ErrorResponse error = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value())
////				.message(e.getMessage()).build();
////		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
////	}
//	
//	
//
//}


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}


