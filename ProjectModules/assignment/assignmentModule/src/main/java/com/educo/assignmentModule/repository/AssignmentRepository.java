package com.educo.assignmentModule.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educo.assignmentModule.models.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, String>{

	List<Assignment> findByClassId(String classId);

	List<Assignment> findBySubject(String subject);

}
