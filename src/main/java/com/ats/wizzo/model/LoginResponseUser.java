package com.ats.wizzo.model;

public class LoginResponseUser {

	private boolean error;
	private String msg;
	private UserPassword userPassword;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public UserPassword getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(UserPassword userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "LoginResponseUser [error=" + error + ", msg=" + msg + ", userPassword=" + userPassword + "]";
	}
	
	

}
