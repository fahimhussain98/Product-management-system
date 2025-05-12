package com.hussain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//public class ErrorResponse {
//
//}



//  @Data
//  @AllArgsConstructor 
//  public class ErrorResponse {
//  
//  private Integer status; 
//  private String message;
//  
//  
//  
//	public ErrorResponse(Integer status, String message) {
//		super();
//		this.status = status;
//		this.message = message;
//	}
//  
//  
//  
//  }
@Data
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;

    // Constructor without errorCode
    public ErrorResponse(Integer status, String message) {
        this(status, "ERR_" + status, message, LocalDateTime.now());
    }

    // Constructor with errorCode
    public ErrorResponse(Integer status, String errorCode, String message) {
        this(status, errorCode, message, LocalDateTime.now());
    }

    // Full constructor (used by @AllArgsConstructor)
    public ErrorResponse(Integer status, String errorCode, String message, LocalDateTime timestamp) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }
}