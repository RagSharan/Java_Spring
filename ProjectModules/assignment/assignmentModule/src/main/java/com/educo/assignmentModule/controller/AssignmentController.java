package com.educo.assignmentModule.controller;

import java.util.ArrayList;
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

import com.educo.assignmentModule.models.Assignment;
import com.educo.assignmentModule.models.Comments;
import com.educo.assignmentModule.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

	@Autowired
	AssignmentService assignmentService;
	
	@PostMapping("/createAssignment")
	public ResponseEntity<String> createAssignemt(@RequestBody Assignment assignment, String mode){
			String assignmentId = assignmentService.createAssignment(assignment, mode);
		ResponseEntity<String> response = new ResponseEntity<String>(assignmentId, HttpStatus.CREATED);
			return response;
	}
	
	@GetMapping("getAssignmentByClass/{classId}")
	public ResponseEntity<List<Assignment>> getClassAssignment(@PathVariable String classId) {
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		assignmentList = assignmentService.getAssignmentByClass(classId);
		ResponseEntity<List<Assignment>> response= new ResponseEntity<List<Assignment>>(assignmentList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAssignmentBySubject/{subject}")
	public ResponseEntity<List<Assignment>> getAssignemtnBySubject(@PathVariable String subject){
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		assignmentList = assignmentService.getAssignmentBySubject(subject);
		ResponseEntity<List<Assignment>> response= new ResponseEntity<List<Assignment>>(assignmentList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAssignmentByStudentId/{studentId}")
	public ResponseEntity<List<Assignment>> getAssignmentByStudentId(@PathVariable String studentId){
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		assignmentList = assignmentService.getAssignmentByStudentId(studentId);
		ResponseEntity<List<Assignment>> response= new ResponseEntity<List<Assignment>>(assignmentList, HttpStatus.OK);
		return response;
	}
	@PostMapping("/setAssignmentStatus")
	public ResponseEntity<Comments> setAssignmentStatus(@RequestBody Comments comment) {
		
		Comments comments = assignmentService.setAssignmentStatus(comment);
		ResponseEntity<Comments> response= new ResponseEntity<Comments>(comments, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("getAssignmentStatus")
	public ResponseEntity<List<Comments>> getAssignmentStatus(@RequestBody String assignmentId) {
		List<Comments> assignmentList = new ArrayList<Comments>();
		assignmentList = assignmentService.getAssignmentStatus(assignmentId);
		ResponseEntity<List<Comments>> response= new ResponseEntity<List<Comments>>(assignmentList, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/postComment")
	public ResponseEntity<Comments> postcomment(@RequestBody Comments comment) {
		Comments comments = assignmentService.setAssignmentStatus(comment);
		ResponseEntity<Comments> response= new ResponseEntity<Comments>(comments, HttpStatus.OK);
		return response;
	}
	@GetMapping("getComments")
	public void getComments() {
		
	}
}
