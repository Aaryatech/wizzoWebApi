package com.ats.wizzo.model;

public class LoginResponseAdmin {
	
	private boolean error;
	private String msg;
	private AdminUser adminUser;
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
	public AdminUser getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	@Override
	public String toString() {
		return "LoginResponseAdmin [error=" + error + ", msg=" + msg + ", adminUser=" + adminUser + "]";
	}
	

}
