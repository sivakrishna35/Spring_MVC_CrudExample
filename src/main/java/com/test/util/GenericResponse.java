package com.test.util;

import java.util.Map;

public class GenericResponse<T> {
	
	private boolean isError;
	private Integer status;
	private T data;
	private Map<String, String> errorMessage;
	
	
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Map<String, String> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Map<String, String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
