package com.educo.assignmentModule.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="assignment")
public class Assignment {
	
	@Id
	@Field("assignmentId")
	private String assignmentId;
	private String subject;
	private String classId;
	private String assignmentContent;
	private String assignmentMode;

	
	public String getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getAssignmentContent() {
		return assignmentContent;
	}
	public void setAssignmentContent(String assignmentContent) {
		this.assignmentContent = assignmentContent;
	}
	public String getAssignmentMode() {
		return assignmentMode;
	}
	public void setAssignmentMode(String assignmentMode) {
		this.assignmentMode = assignmentMode;
	}
		
}
