package com.educo.institute.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import com.educo.institute.models.Institute;


public interface InstituteRepository extends MongoRepository<Institute, String> {
	
	 public Institute findByInstituteId(String instituteId) ;

}
