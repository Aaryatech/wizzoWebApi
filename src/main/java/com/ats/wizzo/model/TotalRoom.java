package com.ats.wizzo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class TotalRoom {
	
	@Id
	@GeneratedValue
	private int roomId;
	private int userId;
	private String roomName;
	private String roomIcon;
	private int roomIsUsed;
	
	@Transient
	private List<Device> deviceList;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomIcon() {
		return roomIcon;
	}

	public void setRoomIcon(String roomIcon) {
		this.roomIcon = roomIcon;
	}

	public int getRoomIsUsed() {
		return roomIsUsed;
	}

	public void setRoomIsUsed(int roomIsUsed) {
		this.roomIsUsed = roomIsUsed;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	@Override
	public String toString() {
		return "TotalRoom [roomId=" + roomId + ", userId=" + userId + ", roomName=" + roomName + ", roomIcon="
				+ roomIcon + ", roomIsUsed=" + roomIsUsed + ", deviceList=" + deviceList + "]";
	}
	
	

}
