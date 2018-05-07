package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rooms")
public class Room {

	@Id
	@GeneratedValue
	private int roomId;
	private int userId;
	private String roomName;
	private String roomIcon;
	private int roomIsUsed;
	
	
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
	public int getRoomIsUsed() {
		return roomIsUsed;
	}
	public void setRoomIsUsed(int roomIsUsed) {
		this.roomIsUsed = roomIsUsed;
	}
	public String getRoomIcon() {
		return roomIcon;
	}
	public void setRoomIcon(String roomIcon) {
		this.roomIcon = roomIcon;
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", userId=" + userId + ", roomName=" + roomName + ", roomIcon=" + roomIcon
				+ ", roomIsUsed=" + roomIsUsed + "]";
	}
	
			
	
}
