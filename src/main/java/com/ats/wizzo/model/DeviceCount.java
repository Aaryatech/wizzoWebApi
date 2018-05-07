package com.ats.wizzo.model;

public class DeviceCount {

	private int totalDevices;

	public int getTotalDevices() {
		return totalDevices;
	}

	public void setTotalDevices(int totalDevices) {
		this.totalDevices = totalDevices;
	}

	@Override
	public String toString() {
		return "DeviceCount [totalDevices=" + totalDevices + "]";
	}

}
