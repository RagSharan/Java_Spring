package com.educo.assignmentModule.service;

import java.util.List;

import com.educo.assignmentModule.models.Assignment;
import com.educo.assignmentModule.models.Comments;

public interface AssignmentService {

	String createAssignment(Assignment assignment, String mode);

	List<Assignment> getAssignmentByClass(String classId);

	List<Assignment> getAssignmentBySubject(String subject);

	List<Assignment> getAssignmentByStudentId(String studentId);

	Comments setAssignmentStatus(Comments comment);

	List<Comments> getAssignmentStatus(String assignmentId);

}
