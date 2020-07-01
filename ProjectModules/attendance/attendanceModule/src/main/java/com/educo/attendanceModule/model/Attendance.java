package com.educo.attendanceModule.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="attendance")
public class Attendance {
	
	@Id
	private String userId;
	private String classId;
	private String subjectId;
	private String markedBy;
	private List<AttendanceStatus> attendanceStatus;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getMarkedBy() {
		return markedBy;
	}
	public void setMarkedBy(String markedBy) {
		this.markedBy = markedBy;
	}
	public List<AttendanceStatus> getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(List<AttendanceStatus> attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
	
	

}
