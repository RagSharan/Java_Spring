package com.educo.assignmentModule.models;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class Comments {
	
	@Id
	private String assignmentId;
	private String studentId;
	private String assignmentStatus;
	private List<CommentText> message;

	public String getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public List<CommentText> getMessage() {
		return message;
	}

	public void setMessage(List<CommentText> message) {
		this.message = message;
	}

}
