package com.comcast.interview.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.comcast.interview.model.ErrorResponse;

@ControllerAdvice
public class LcsCustomExceptionHandler extends ResponseEntityExceptionHandler  {
    
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public  ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), "LCS Strings needed for validation!");
		return ResponseEntity.unprocessableEntity().body(errorResponse);
	}
	
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementException itemNotFoundException, WebRequest request) {
    	ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Validation error. Check 'errors' field for details.");
		return ResponseEntity.unprocessableEntity().body(errorResponse);
    }
    
    @ExceptionHandler(BadRequestLcsException.class)
    public ResponseEntity<Object> handleBadRequestLcsException(BadRequestLcsException itemNotFoundException, WebRequest request) {
    	ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), itemNotFoundException.getMessage());
		return ResponseEntity.unprocessableEntity().body(errorResponse);
    }
	
}
