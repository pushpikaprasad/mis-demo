package lk.ac.pdn.eng.mis.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	 
	public void save(Application application) {
		applicationRepository.save(application);
	}
	
	//get all application details
	public List<Application> getApplications(){
		return applicationRepository.findAll();
	}
	
	//get specific application details
	public Application getApplicationByID(int id) {
		return applicationRepository.findById(id).get(); //CHECK get()
	}
	
	//get application by registration No
	public List<Application> getApplicationByRegNo(String regNo) {
		return applicationRepository.findApplicationByRegNo(regNo);
	}
	
	//Set status of Application
	public void setStatusApplication(int id, String status) {
		Application application = applicationRepository.findByApplicationId(id);
		application.setStatus(status);
		applicationRepository.save(application);
	}
	
	public void setStatusApplicationDetails(int id, String status) {
		Application application = applicationRepository.findByApplicationId(id);
		String currentStatus = application.getStatusDetails();
		application.setStatusDetails(currentStatus+status);
		applicationRepository.save(application);
	}
	
	//Get applications based on status
	public List<Application> getApplicationByStatus(String status){
		return applicationRepository.findByStatus(status);
	}
	
	//Create Application
	public void createApplication(Application application) {
		String date = new Date().toLocaleString();
		application.setStatusDetails("\u2022 New application received on "+date);
		applicationRepository.save(application);
	}
	
	//find application by Date
	public Application getApplicationByDate(String date) {
		return applicationRepository.findByDate(date);
	}
	
	// send pdf attachment
	public void sendEmailWithPDF(String toSend, String title, String messageText, int id) throws MessagingException {

			MimeMessage msg = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setFrom("cp.eng.pdn@gmail.com");
			helper.setTo(toSend);

			URL fileURL = null;
			try {
				fileURL = new URL("http://localhost:8080/studentDashboard/downloadApplication/" + id);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}  
			URLDataSource file = new URLDataSource(fileURL);
			helper.addAttachment("Application-" + id + ".pdf", file);
			helper.setSubject(title);
			helper.setText(messageText);
			javaMailSender.send(msg);

		}
}
