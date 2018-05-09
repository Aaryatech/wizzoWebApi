package com.ats.wizzo.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSupportList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="token_id")
	private int tokenId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="assigned_to")
	private int assignedTo;
	
	@Column(name="issue_desc")
	private String issueDesc;

	@Column(name="issue_raised_datetime")
	private Date issueRaisedDatetime;
	
	@Column(name="solution_provided")
	private String solutionProvided;
	
	@Column(name="solution_datetime")
	private Date solutionDatetime;
	
	@Column(name="status")
	private int status;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="emp_name")
	private String empName;

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getIssueDesc() {
		return issueDesc;
	}

	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm:ss")
	public Date getIssueRaisedDatetime() {
		return issueRaisedDatetime;
	}

	public void setIssueRaisedDatetime(Date issueRaisedDatetime) {
		this.issueRaisedDatetime = issueRaisedDatetime;
	}

	public String getSolutionProvided() {
		return solutionProvided;
	}

	public void setSolutionProvided(String solutionProvided) {
		this.solutionProvided = solutionProvided;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm:ss")
	public Date getSolutionDatetime() {
		return solutionDatetime;
	}

	public void setSolutionDatetime(Date solutionDatetime) {
		this.solutionDatetime = solutionDatetime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "GetSupportList [tokenId=" + tokenId + ", userId=" + userId + ", assignedTo=" + assignedTo
				+ ", issueDesc=" + issueDesc + ", issueRaisedDatetime=" + issueRaisedDatetime + ", solutionProvided="
				+ solutionProvided + ", solutionDatetime=" + solutionDatetime + ", status=" + status + ", userName="
				+ userName + ", empName=" + empName + "]";
	}
	
	
	
	

}
