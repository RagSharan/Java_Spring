package com.educo.institute.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="institute")
public class Institute {
	
	
	
	@Id
	@Field("instituteId")
	private String instituteId;
	private String instituteName;
	private String instituteCity;
	private String instituteBio;
	private List<String> management;
	private List<String> teachers;
	private List<String> classesId;
	private List<String> studentsId;
	//private int instRanking;
	
	
	public String getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInstituteCity() {
		return instituteCity;
	}
	public void setInstituteCity(String instituteCity) {
		this.instituteCity = instituteCity;
	}
	public String getInstituteBio() {
		return instituteBio;
	}
	public void setInstituteBio(String instituteBio) {
		this.instituteBio = instituteBio;
	}
	public List<String> getManagement() {
		return management;
	}
	public void setManagement(List<String> management) {
		this.management = management;
	}
	public List<String> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}
	public List<String> getClassesId() {
		return classesId;
	}
	public void setClassesId(List<String> classesId) {
		this.classesId = classesId;
	}
	public List<String> getStudentsId() {
		return studentsId;
	}
	public void setStudentsId(List<String> studentsId) {
		this.studentsId = studentsId;
	}
	
	
	
	
	

}
