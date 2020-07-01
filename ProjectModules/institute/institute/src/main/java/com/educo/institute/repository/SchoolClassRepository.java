package com.educo.institute.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.educo.institute.models.SchoolClass;

public interface SchoolClassRepository extends MongoRepository<SchoolClass, String> {

	//public List<SchoolClass>findAllById(List<String> classIds);
	
	List<SchoolClass> findAllByInstituteId(String instituteId);
}
