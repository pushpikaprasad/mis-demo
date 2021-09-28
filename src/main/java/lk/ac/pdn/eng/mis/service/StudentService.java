package lk.ac.pdn.eng.mis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.entity.Student;
import lk.ac.pdn.eng.mis.repository.ApplicationRepository;
import lk.ac.pdn.eng.mis.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicationService applicationService;
	
	//Get Student
	public Student getStudent(String username) {
		return studentRepository.findByUsername(username);
	}
	
	//Create Application
	public void createApplication(Application application) {
		//applicationRepository.save(application);
		applicationService.createApplication(application);
	}

	//get application PDF 
	public Application getPDFApplication(int id) {
		return applicationRepository.findByApplicationId(id);
	}

	public Application getApplicationByDate(String date) {
		return applicationRepository.findByDate(date);
	}
	
	
}
