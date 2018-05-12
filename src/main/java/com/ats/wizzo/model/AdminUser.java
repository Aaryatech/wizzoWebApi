package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_admin")
public class AdminUser {

	@Id
	@GeneratedValue
	private int userId;

	private String userMobile;

	private String userPassword;

	private String token;

	private int isUsed;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "AdminUser [userId=" + userId + ", userMobile=" + userMobile + ", userPassword=" + userPassword
				+ ", token=" + token + ", isUsed=" + isUsed + "]";
	}

}
