package com.educo.institute.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educo.institute.models.Institute;
import com.educo.institute.models.SchoolClass;
import com.educo.institute.models.Student;
import com.educo.institute.models.Teacher;
import com.educo.institute.service.InstituteService;

@RestController
@RequestMapping("/institute")
public class InstituteController {
	
	@Autowired
	InstituteService instituteService;
	
	
	//Institute services
	@PostMapping("/registerInstitute")
	public ResponseEntity<Institute> registerInstitute(@RequestBody Institute institute) {
		ResponseEntity<Institute> responseEntity;
		Institute response = instituteService.registerInstitute(institute);
		 responseEntity= new ResponseEntity<Institute>(response, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/updateInstituteInfo")
	public ResponseEntity<Institute> updateInstitute(@RequestBody Institute institute) {
		ResponseEntity<Institute> responseEntity;
		Institute response = instituteService.updateInstituteInfo(institute);
		 responseEntity= new ResponseEntity<Institute>(response, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getInstituteInfo/{instituteId}")
	public ResponseEntity<Institute> getInstitueInfo(@PathVariable("instituteId") String instituteId) {
		ResponseEntity<Institute> responseEntity;
		Institute institute = instituteService.getInstitueInfo(instituteId);
		responseEntity = new ResponseEntity<Institute>(institute, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/searchInstitutesByName/{instituteName}")
	public ResponseEntity<List<Institute>> searchInstitutes(@PathVariable String instituteName) {
		ResponseEntity<List<Institute>> responseEntity;
		List<Institute> instituteList = instituteService.searchInstituesByName(instituteName);
		responseEntity = new ResponseEntity<List<Institute>>(instituteList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	@GetMapping("/searchInstitutesByCity/{instituteCity}")
	public ResponseEntity<List<Institute>> searchInstitutesByCity(@PathVariable String instituteCity) {
		ResponseEntity<List<Institute>> responseEntity;
		List<Institute> instituteList = instituteService.searchInstituesByCity(instituteCity);
		responseEntity = new ResponseEntity<List<Institute>>(instituteList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	//class services
	@PostMapping("/createClass")
	public ResponseEntity<SchoolClass> createClasses(@RequestBody SchoolClass classEntity) {
		ResponseEntity<SchoolClass> responseEntity;
		SchoolClass classes = instituteService.createInstituteClass(classEntity);
		responseEntity = new ResponseEntity<SchoolClass>(classes, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllClasses")
	public ResponseEntity<List<SchoolClass>> getAllClasses(@RequestBody String instituteId) {
		ResponseEntity<List<SchoolClass>> responseEntity;
		List<SchoolClass> classes = instituteService.getInstituteClasses(instituteId);
		responseEntity = new ResponseEntity<List<SchoolClass>>(classes, HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	//student services
	@PostMapping("/assignStudents")
	public ResponseEntity<SchoolClass> assignStudents(@RequestBody SchoolClass classEntity) {
		ResponseEntity<SchoolClass> responseEntity;
		SchoolClass classes = instituteService.updateInstituteClass(classEntity);
		responseEntity = new ResponseEntity<SchoolClass>(classes, HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/getClassStudents/{classId}")
	public ResponseEntity<List<Student>> getClassStudents(@PathVariable String classId) {
		ResponseEntity<List<Student>> responseEntity;
		List<Student> studentList = instituteService.getStudentListByClassId(classId);
		responseEntity = new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getInstitueStudents")
	public ResponseEntity<List<Student>> getInstitueStudents(@PathVariable String classId){
		ResponseEntity<List<Student>> responseEntity;
		List<Student> studentList = instituteService.getStudentListByInstituteId(classId);
		responseEntity = new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		return responseEntity;
	}
	
	
	//teacher services
	@PostMapping("/assignTeachers")
	public ResponseEntity<SchoolClass> assignTeachers(@RequestBody SchoolClass classEntity) {
		ResponseEntity<SchoolClass> responseEntity;
		SchoolClass classes = instituteService.updateInstituteClass(classEntity);
		responseEntity = new ResponseEntity<SchoolClass>(classes, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getTeacherList")
	public ResponseEntity<List<Teacher>> getTeacherList(String instituteId) {
		ResponseEntity<List<Teacher>> response ;
		List<Teacher> teacherList = instituteService.getTeacherListByInstituteId(instituteId);
		response = new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.ACCEPTED);
		return response;
	}
	
	@PostMapping("/createNewSessionYear")
	public void createNewSession() {
		
	}
	
	@PostMapping("/createLecturePlan")
	public void createLecturePlan() {
		
	}
	
	@GetMapping("/getLecturePlan")
	public void getLecturePlan() {
		
	}
	
}
