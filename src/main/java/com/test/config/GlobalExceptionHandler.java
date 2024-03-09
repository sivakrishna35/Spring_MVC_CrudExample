package com.test.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.test.util.CommonUtil;
import com.test.util.ExceptionResponse;
import com.test.util.GenericResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {UserIdNotFoundException.class})
	public ResponseEntity<GenericResponse<Object>> handleUserNotFoundException(UserIdNotFoundException ex,WebRequest request){
		ExceptionResponse response = CommonUtil.prepareExceptionResponse(request, ex.getMessage());
		return new ResponseEntity<>(CommonUtil.getHttpResponse(true, response,  HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {ServiceException.class})
	public ResponseEntity<GenericResponse<Object>> handleServiceException(ServiceException ex,WebRequest request){
		ExceptionResponse response = CommonUtil.prepareExceptionResponse(request, ex.getMessage());
		return new ResponseEntity<>(CommonUtil.getHttpResponse(true, response,  HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<GenericResponse<Object>> handleException(Exception ex,WebRequest request){
		ExceptionResponse response = CommonUtil.prepareExceptionResponse(request, ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(CommonUtil.getHttpResponse(true, response,  HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	} 

}
