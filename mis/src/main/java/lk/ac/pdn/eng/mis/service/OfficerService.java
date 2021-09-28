package lk.ac.pdn.eng.mis.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.entity.Employee;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.entity.User;
import lk.ac.pdn.eng.mis.repository.ApplicationRepository;
import lk.ac.pdn.eng.mis.repository.OfficerRepository;

@Service
public class OfficerService {

	@Autowired
	private OfficerRepository officerRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationService applicationService;

	// get Officer
	public Officer getOfficer(String username) {
		return officerRepository.getOfficerByUsername(username);
	}

	// ###############################################################################################################################
	/* APPLICATION PROCESS */

	// View Application
	public Application getApplication(int id) {
		return applicationService.getApplicationByID(id);
	}

	// Get all transcript/academic rank certificate applications
	public List<Application> getAllTanAndAcaApps() {
		return applicationService.getApplications();
	}
	
	//Get all applications by Registration no
	public List<Application> getAllApplicationsByRegNo(String regNo) {
		return applicationService.getApplicationByRegNo(regNo);
	}

	// Get all new applications
	public List<Application> getAllNewApplications() {
		return applicationService.getApplicationByStatus("new");
	}

	// Get all accepted applications
	public List<Application> getAllAcceptedApplication() {
		return applicationService.getApplicationByStatus("accepted");
	}

	// Get all rejected applications
	public List<Application> getAllRejectedApplication() {
		return applicationService.getApplicationByStatus("rejected");
	}
	
	// Get all prepared applications
		public List<Application> getAllPreparedApplication() {
			return applicationService.getApplicationByStatus("prepared");
		}

	// Get all checked-OK applications
	public List<Application> getAllCheckedOKApplication() {
		return applicationService.getApplicationByStatus("checked_OK");
	}

	// Get all checked-Not OK applications
	public List<Application> getAllCheckedNotOKApplication() {
		return applicationService.getApplicationByStatus("checked_Not_OK");
	}

	// Get all completed applications
	public List<Application> getAllCompletedTranAcadApplication() {
		return applicationService.getApplicationByStatus("completed");
	}

	// Get all finished applications
	public List<Application> getAllFinishedTranAcadApplication() {
		return applicationService.getApplicationByStatus("done");
	}

	// Accept application ---> Status: Transcript/Aca-Rank documents accepted
	public void acceptApplication(int id, String officerName) {
		
		Application application = applicationService.getApplicationByID(id);
		
		applicationService.setStatusApplication(id, "accepted");
		
		String title = "Your application has been accepted";
		String msg = "Dear Student,\n\nYour application has been accepted and process is started." + "\n\nThank you.";
		String emailAddress = application.getEmail();
		sendEmail(emailAddress, title, msg);
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(id, "\n\u2022 Accepted by " + officerName + " on " + date);
	}

	// Reject application ---> Status: Transcript/Aca-Rank documents rejected
	public void rejectApplication(int id, String reason, String OfficerName) {
		Application application = applicationService.getApplicationByID(id);
		String title = "Your application has been rejected";
		String msg = "Dear Student,\n\nYour application has been rejected due to follwing reason.\nREASON: \n\t"
				+ reason
				+ "\n\nPlease contact AR office to futher details and please re submit your application with the corrections."
				+ "\n\nThank you.";
		String emailAddress = application.getEmail();
		sendEmail(emailAddress, title, msg);
		applicationService.setStatusApplication(id, "rejected");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(id,
				"\n\u2022 Rejected by " + OfficerName + " on " + date + ". Due to the reason of \"" + reason + "\".");
	}

	// prepared transcript document of Application
	public void preparedT_Documents(int applicationId, String officerName) throws MessagingException {
		applicationService.setStatusApplication(applicationId, "prepared");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId,
				"\n\u2022 Prepared Transcript document by " + officerName + " on " + date);
	}

	// prepared transcript document of Application
	public void preparedA_Documents(int applicationId, String officerName) throws MessagingException {
		applicationService.setStatusApplication(applicationId, "prepared");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId,
				"\n\u2022 Prepared Academic Rank document by " + officerName + " on " + date);
	}

	// checked OK
	public void checkedOKApplication(int applicationId, String officerName) {
		applicationService.setStatusApplication(applicationId, "checked_OK");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId,
				"\n\u2022 Checked - OK by " + officerName + " on " + date);
	}

	// checked Not OK
	public void checkedNotOKApplication(int applicationId, String reason, String officerName) {
		applicationService.setStatusApplication(applicationId, "checked_Not_OK");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId, "\n\u2022 Checked - NOT OK by " + officerName
				+ " on " + date + ". Due to the reason of \"" + reason + "\".");
	}

	// complete application ---> Status: Transcript/Aca-Rank documents completed
	public void completedApplication(int applicationId, String officerName) {
		applicationService.setStatusApplication(applicationId, "completed");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId,
				"\n\u2022 Document creation is completed by " + officerName + " on " + date);
	}

	// Done Application
	public void doneApplication(int applicationId, String officerName) throws MessagingException {
		Application application = applicationService.getApplicationByID(applicationId);
		String title = "Transcript/Academic Rank Certificate process is completed.";
		String msg = "Dear Student,<br><br>Your application process is completed.<br>You can contact Ar office for futher information."
				+ "<br><br>Thank you.";
		String emailAddress = application.getEmail();
		sendEmailHTML(emailAddress, title, msg);
		applicationService.setStatusApplication(applicationId, "done");
		String date = new Date().toLocaleString();
		applicationService.setStatusApplicationDetails(applicationId,
				"\n\u2022 Process is completed and notification is sent by " + officerName + " to email: "
						+ emailAddress + " on " + date);
	}

	// download application
	public void downloadPDFApplication(int id, HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=application_" + id + ".pdf";
		response.setHeader(headerKey, headerValue);

		ApplicationPDFExporter exporter = new ApplicationPDFExporter(applicationService.getApplicationByID(id));

		exporter.export(response);
	}

	// Upload transcript documents
	public void setTranscriptDocumentData(int applicationID, MultipartFile transcriptDocument) {

		// get application
		Application application = applicationService.getApplicationByID(applicationID);

		try {
			if(transcriptDocument.getBytes().length > 0) {
			application.setTranscriptDocument(transcriptDocument.getBytes());
			applicationService.save(application);
			}

		} catch (IOException e) {
			throw new RuntimeException("fail to store transcript word data: " + e.getMessage());
		}

	}

	// Upload academic rank documents
	public void setAcademicDocumentData(int applicationID, MultipartFile academicDocument) {
		// get application
		Application application = applicationService.getApplicationByID(applicationID);
		
		try {
			if(academicDocument.getBytes().length > 0) {
			application.setAcademicRankDocument(academicDocument.getBytes());
			applicationService.save(application);
			}
		} catch (IOException e) {
			throw new RuntimeException("fail to store transcript word data: " + e.getMessage());
		}
	}
	
	
	// ###############################################################################################################################

	// send email to student ---> Status: Transcript/Aca-Rank documents completed
	public void sendEmail(String emailAddress, String title, String msg) {
		userService.sendEmail(emailAddress, title, msg);
	}

	// send email to student(with HTML) ---> Status: Transcript/Aca-Rank documents
	// completed
	public void sendEmailHTML(String emailAddress, String title, String msg) throws MessagingException {
		userService.sendEmailHTML(emailAddress, title, msg);
	}

	// send email to list
	public void sendEmailToList(InternetAddress[] internetAddresses, String title, String msg)
			throws MessagingException {
		userService.sendEmailToList(internetAddresses, title, msg);

	}

	// update officer
	public void updateOfficer(Officer editOfficer) {
		try {

			officerRepository.save(editOfficer);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + " updateOfficer() gives null object!");
		}
	}

	public InternetAddress[] getEmailListofOfficersByWCID(int i) throws AddressException {
		List<User> listOfUsers = userService.getEmailListofOfficersByWCID(i);

		// List<InternetAddress> listOfToAddress = new List<InternetAddress>();
		InternetAddress[] addresses = new InternetAddress[listOfUsers.size()];
		for (int u = 0; u < listOfUsers.size(); u++) {
			addresses[u] = new InternetAddress(listOfUsers.get(u).getEmail());
		}
		System.out.println(addresses.toString());
		return addresses;
	}

	// set work number for officer
	/*
	 * public void setWorkNo(String username, int n) { Officer officer =
	 * officerRepository.getOfficerByUsername(username); officer.setWork_no(n); }
	 */

	// get work number of officer
	/*
	 * public int getWorkNo(String username) { Officer officer =
	 * officerRepository.getOfficerByUsername(username); return
	 * officer.getWork_no(); }
	 */
}
