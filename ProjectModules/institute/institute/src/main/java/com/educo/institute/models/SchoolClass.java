package com.educo.institute.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="ClassEntity")
public class SchoolClass {
	
	@Id
	@Field("classId")
	private String classId;
	private String instituteId;
	private String className;
	private String classTeacher;
	private List<String> studentList;
	private List<String> subjectList;
	
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(String instId) {
		this.instituteId = instId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public List<String> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<String> studentList) {
		this.studentList = studentList;
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}

	
	
}
