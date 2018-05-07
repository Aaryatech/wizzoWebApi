package com.ats.wizzo.model;

public class ErrorMessage {
	
	
	private String message; 
	private boolean isError;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	

}
