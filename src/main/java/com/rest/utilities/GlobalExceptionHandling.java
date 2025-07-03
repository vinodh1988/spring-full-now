package com.rest.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandling.class);
	@ExceptionHandler(value= {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {RecordNotFoundException.class})
	protected ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException e){
		 String response= e.getMessage();
		 logger.error("Record not found: {}", response);
		 return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {RecordAlreadyExistsException.class})
	protected ResponseEntity<Object> handleRecordAlreadyExistsException(RecordAlreadyExistsException e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {Exception.class})
	protected ResponseEntity<Object> handleException(Exception e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
