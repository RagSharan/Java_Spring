package com.educo.institute.repository.repositoryDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.educo.institute.models.Institute;


@Component
public class InstituteRepositotyDAO  {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public Institute findInstituteById(String instituteId){
		
		Query query = new Query(Criteria.where("_id").is(instituteId));
		Institute institute =(Institute) mongoTemplate.find(query, Institute.class);
		return institute;
	}

}
