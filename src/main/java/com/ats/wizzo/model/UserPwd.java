package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_user_password")
public class UserPwd {

	@Id
	@GeneratedValue
	private int userId;

	private String userPassword;

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserPwd [userId=" + userId + ", userPassword=" + userPassword + "]";
	}

	
}
