package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_user")
public class User {

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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", authKey=" + authKey + ", userName=" + userName + ", userMobile="
				+ userMobile + ", userEmail=" + userEmail + ", userLocation=" + userLocation + ", userPic=" + userPic
				+ ", userIsUsed=" + userIsUsed + "]";
	}
	
	
	
		
	
}
