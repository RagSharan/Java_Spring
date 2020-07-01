package com.educo.attendanceModule.model;

import java.util.Date;

public class AttendanceStatus {
	
	private String userId;
	private String status;
	private Date statusTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

}
