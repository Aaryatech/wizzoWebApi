package com.ats.wizzo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_enquiry")
public class Enquiry {

	@Id
	@GeneratedValue
	private int enqId;

	private String name;

	private String mobileNo;

	private String emailId;

	private String location;

	private String message;

	private int enqType;

	private int status;

	private String enqDatetime;

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEnqType() {
		return enqType;
	}

	public void setEnqType(int enqType) {
		this.enqType = enqType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEnqDatetime() {
		return enqDatetime;
	}

	public void setEnqDatetime(String enqDatetime) {
		this.enqDatetime = enqDatetime;
	}

	@Override
	public String toString() {
		return "Enquiry [enqId=" + enqId + ", name=" + name + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", location=" + location + ", message=" + message + ", enqType=" + enqType + ", status=" + status
				+ ", enqDatetime=" + enqDatetime + "]";
	}

}
