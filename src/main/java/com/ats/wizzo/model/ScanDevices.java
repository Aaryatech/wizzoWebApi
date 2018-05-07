package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_scan_devices")
public class ScanDevices {


	@Id
	@GeneratedValue
	private int devId;
	
	private int userId;
	
	private String devMac;

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

	public String getDevMac() {
		return devMac;
	}

	public void setDevMac(String devMac) {
		this.devMac = devMac;
	}

	@Override
	public String toString() {
		return "ScanDevices [devId=" + devId + ", userId=" + userId + ", devMac=" + devMac + "]";
	}
	
	
	
}
