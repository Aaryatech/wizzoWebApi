package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPassword {

	@Id
	@GeneratedValue
	private int userId;
	private String authKey;
	private String userName;
	private String userMobile;
	private String userEmail;
	private String userLocation;
	private String userPic;
	private int userIsUsed;
	private String userPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public int getUserIsUsed() {
		return userIsUsed;
	}

	public void setUserIsUsed(int userIsUsed) {
		this.userIsUsed = userIsUsed;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserPassword [userId=" + userId + ", authKey=" + authKey + ", userName=" + userName + ", userMobile="
				+ userMobile + ", userEmail=" + userEmail + ", userLocation=" + userLocation + ", userPic=" + userPic
				+ ", userIsUsed=" + userIsUsed + ", userPassword=" + userPassword + "]";
	}

}
