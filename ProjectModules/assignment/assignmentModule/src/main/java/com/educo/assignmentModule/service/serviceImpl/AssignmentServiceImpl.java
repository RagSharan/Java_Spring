package com.educo.assignmentModule.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educo.assignmentModule.models.Assignment;
import com.educo.assignmentModule.models.Comments;
import com.educo.assignmentModule.repository.AssignmentRepository;
import com.educo.assignmentModule.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	
	@Autowired
	AssignmentRepository assignmentRepo;
	
	@Override
	public String createAssignment(Assignment assignment, String mode) {
		assignment = assignmentRepo.save(assignment);
		return assignment.getAssignmentId();
	}

	@Override
	public List<Assignment> getAssignmentByClass(String classId) {
		List<Assignment> assignmentList =new ArrayList<Assignment>();
		assignmentList = assignmentRepo.findByClassId(classId);
		return assignmentList;
	}

	@Override
	public List<Assignment> getAssignmentBySubject(String subject) {
		List<Assignment> assignmentList =new ArrayList<Assignment>();
		assignmentList = assignmentRepo.findBySubject(subject);
		return assignmentList;		
	}

	@Override
	public List<Assignment> getAssignmentByStudentId(String studentId) {
		
		return null;
	}

	@Override
	public Comments setAssignmentStatus(Comments comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comments> getAssignmentStatus(String assignmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
