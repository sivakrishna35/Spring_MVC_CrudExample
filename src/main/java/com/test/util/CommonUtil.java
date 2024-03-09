package com.test.util;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

public class CommonUtil {
	private CommonUtil()
	{
		
	}
	
public static <T> GenericResponse<T> getHttpResponse(boolean isError, T data, Map<String, String> errorMessage, HttpStatus status){
	GenericResponse<T> genericResponse = new GenericResponse<>();
	genericResponse.setError(isError);
	genericResponse.setStatus(status.value());
	genericResponse.setData(data);
	genericResponse.setErrorMessage(errorMessage);
	return genericResponse;
}

public static <T> GenericResponse<T> getHttpResponse(boolean isError, T data, HttpStatus status){
	GenericResponse<T> genericResponse = new GenericResponse<>();
	genericResponse.setError(isError);
	genericResponse.setStatus(status.value());
	genericResponse.setData(data);
	return genericResponse;
}

public static ExceptionResponse prepareExceptionResponse(WebRequest request, String message) {
	ExceptionResponse error = new ExceptionResponse();
	error.getMessage().add(message);
	error.setPath(request.getContextPath());
	return error;
}
}
