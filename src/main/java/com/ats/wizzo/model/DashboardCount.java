package com.ats.wizzo.model;

public class DashboardCount {

	private int DeviceCount;

	private int TotalNewOrders;

	private int TotalNoOfUsers;

	private int TotalPendingIssues;

	public int getDeviceCount() {
		return DeviceCount;
	}

	public void setDeviceCount(int deviceCount) {
		DeviceCount = deviceCount;
	}

	public int getTotalNewOrders() {
		return TotalNewOrders;
	}

	public void setTotalNewOrders(int totalNewOrders) {
		TotalNewOrders = totalNewOrders;
	}

	public int getTotalNoOfUsers() {
		return TotalNoOfUsers;
	}

	public void setTotalNoOfUsers(int totalNoOfUsers) {
		TotalNoOfUsers = totalNoOfUsers;
	}

	public int getTotalPendingIssues() {
		return TotalPendingIssues;
	}

	public void setTotalPendingIssues(int totalPendingIssues) {
		TotalPendingIssues = totalPendingIssues;
	}

	@Override
	public String toString() {
		return "DashboardCount [DeviceCount=" + DeviceCount + ", TotalNewOrders=" + TotalNewOrders + ", TotalNoOfUsers="
				+ TotalNoOfUsers + ", TotalPendingIssues=" + TotalPendingIssues + "]";
	}

	

}
