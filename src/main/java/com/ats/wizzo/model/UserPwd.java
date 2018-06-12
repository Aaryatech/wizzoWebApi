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
	private int uId;

	private String userPassword;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserPwd [uId=" + uId + ", userPassword=" + userPassword + "]";
	}

}
