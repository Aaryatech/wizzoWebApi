package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_device")
public class Device {

	@Id
	@GeneratedValue
	private int devId;
	
	private int userId;
	private String devIp;
	private String devMac;
	private String devCaption;
	private int devType;
	private int devPosition;
	private String devSsid;
	private int roomId;
	private int devIsUsed;
	
	
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDevIp() {
		return devIp;
	}
	public void setDevIp(String devIp) {
		this.devIp = devIp;
	}
	public String getDevMac() {
		return devMac;
	}
	public void setDevMac(String devMac) {
		this.devMac = devMac;
	}
	public String getDevCaption() {
		return devCaption;
	}
	public void setDevCaption(String devCaption) {
		this.devCaption = devCaption;
	}
	public int getDevType() {
		return devType;
	}
	public void setDevType(int devType) {
		this.devType = devType;
	}
	public int getDevPosition() {
		return devPosition;
	}
	public void setDevPosition(int devPosition) {
		this.devPosition = devPosition;
	}
	public String getDevSsid() {
		return devSsid;
	}
	public void setDevSsid(String devSsid) {
		this.devSsid = devSsid;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getDevIsUsed() {
		return devIsUsed;
	}
	public void setDevIsUsed(int devIsUsed) {
		this.devIsUsed = devIsUsed;
	}
	
	
	
	@Override
	public String toString() {
		return "Device [devId=" + devId + ", userId=" + userId + ", devIp=" + devIp + ", devMac=" + devMac
				+ ", devCaption=" + devCaption + ", devType=" + devType + ", devPosition=" + devPosition + ", devSsid="
				+ devSsid + ", roomId=" + roomId + ", devIsUsed=" + devIsUsed + "]";
	}
	
	
	
	
	
}
