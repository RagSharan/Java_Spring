package com.educo.institute.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="teacher")
public class Teacher {
	
	@Id
	private String teacherId;
	
	private String teacherName;
	
	private String instituteId;
	
	private Set<String> classIds;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public Set<String> getClassIds() {
		return classIds;
	}

	public void setClassIds(Set<String> classIds) {
		this.classIds = classIds;
	}
	
	
	

}
