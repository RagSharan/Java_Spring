package com.educo.institute.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educo.institute.exceptions.InstituteNotFoundException;
import com.educo.institute.models.Institute;
import com.educo.institute.models.SchoolClass;
import com.educo.institute.models.Student;
import com.educo.institute.models.Teacher;
import com.educo.institute.repository.SchoolClassRepository;
import com.educo.institute.repository.InstituteRepository;
import com.educo.institute.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	InstituteRepository instituteRepo;

	@Autowired
	SchoolClassRepository classRepo;
	
	private Institute institute;
	
	private SchoolClass schoolClass;
	
	@Override
	public Institute registerInstitute(Institute institute) {
		this.institute = instituteRepo.insert(institute);
		return this.institute;
		
	}

	@Override
	public Institute updateInstituteInfo(Institute institute) {
		boolean isPresent = instituteRepo.existsById(institute.getInstituteId());
		if(!isPresent) {
			throw new InstituteNotFoundException("Institute is not register with us");
		}
		instituteRepo.save(institute);
		return institute;
	}

	@Override
	public Institute getInstitueInfo(String instituteId) {
		institute = instituteRepo.findByInstituteId(instituteId);
		
		return institute;
	}

	@Override
	public SchoolClass createInstituteClass(SchoolClass classEntity) {
		List<String> classesId = new ArrayList<String>();
		String instituteId = classEntity.getInstituteId();
		boolean isPresent = instituteRepo.existsById(instituteId);
		if(isPresent) {
			schoolClass = classRepo.insert(classEntity);
			classesId.add(schoolClass.getClassId());
			this.institute = instituteRepo.findByInstituteId(instituteId);
			if(this.institute.getClassesId() != null)
				classesId.addAll(this.institute.getClassesId());
			this.institute.setClassesId(classesId);
			instituteRepo.save(this.institute);
		}
		
		return schoolClass;
	}

	@Override
	public List<SchoolClass> getInstituteClasses(String instituteId) {
		List<SchoolClass> classes = new ArrayList<SchoolClass>();
		boolean isPresent = instituteRepo.existsById(instituteId);
		if(isPresent) {
			classes = classRepo.findAllByInstituteId(instituteId);
		}
		
		return classes;
	}

	@Override
	public List<Institute> searchInstituesByName(String instituteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Institute> searchInstituesByCity(String instituteCity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SchoolClass updateInstituteClass(SchoolClass classEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentListByClassId(String classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentListByInstituteId(String classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getTeacherListByInstituteId(String instituteId) {
		// TODO Auto-generated method stub
		return null;
	}



}
