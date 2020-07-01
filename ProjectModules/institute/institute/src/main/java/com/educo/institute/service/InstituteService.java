package com.educo.institute.service;


import java.util.List;

import com.educo.institute.models.Institute;
import com.educo.institute.models.SchoolClass;
import com.educo.institute.models.Student;
import com.educo.institute.models.Teacher;

public interface InstituteService {

	Institute registerInstitute(Institute institute);

	Institute updateInstituteInfo(Institute institute);

	Institute getInstitueInfo(String instituteId);

	List<Institute> searchInstituesByName(String instituteName);

	List<Institute> searchInstituesByCity(String instituteCity);

	SchoolClass createInstituteClass(SchoolClass classEntity);

	List<SchoolClass> getInstituteClasses(String instituteId);

	SchoolClass updateInstituteClass(SchoolClass classEntity);

	List<Student> getStudentListByClassId(String classId);

	List<Student> getStudentListByInstituteId(String classId);

	List<Teacher> getTeacherListByInstituteId(String instituteId);
	
	


}
