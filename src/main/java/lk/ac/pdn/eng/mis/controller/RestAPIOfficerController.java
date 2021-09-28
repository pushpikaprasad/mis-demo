package lk.ac.pdn.eng.mis.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.service.ApplicationPDFExporter;
import lk.ac.pdn.eng.mis.service.OfficerService;

@RestController
public class RestAPIOfficerController {

	@Autowired
	private OfficerService officerService;

	// Get Officer
	@GetMapping(value = "/officerDashboard/getOfficer")
	public Officer getOfficer(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return officerService.getOfficer(userDetails.getUsername());
	}

	// update officer
	@PostMapping(value = "/officerDashboard/updateOfficer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateOfficer(@RequestBody Officer editOfficer, Authentication authentication) {
		officerService.updateOfficer(editOfficer);

	}

	// ###############################################################################################################################
	/* APPLICATION PROCESS */

	// Get all applications
	@GetMapping(value = "/officerDashboard/allApplications")
	public List<Application> getAllApllications() {
		return officerService.getAllTanAndAcaApps();
	}
	
	// Get all applications by Registration No
	@GetMapping(value = "/officerDashboard/searchApplications/{registrationNo}")
	public List<Application> getApplicationByRegNo(@PathVariable("registrationNo") String registrationNo){
		String regNo = registrationNo.replaceAll("_", "/");
		return officerService.getAllApplicationsByRegNo(regNo);
	}

	// Get all new applications
	@GetMapping(value = "/officerDashboard/allNewApplications")
	public List<Application> getAllNewApllications() {
		return officerService.getAllNewApplications();
	}

	// Get all accepted applications
	@GetMapping(value = "/officerDashboard/allAcceptedApplications")
	public List<Application> getAllAcceptedTranAcadApllications() {
		return officerService.getAllAcceptedApplication();
	}

	// Get all rejected applications
	@GetMapping(value = "/officerDashboard/allRejectedApplications")
	public List<Application> getAllRejectedTranAcadApllications() {
		return officerService.getAllRejectedApplication();
	}

	// Get all prepared applications
	@GetMapping(value = "/officerDashboard/allPreparedApplications")
	public List<Application> getAllPreparedApplications() {
		return officerService.getAllPreparedApplication();
	}

	// Get all checked OK applications
	@GetMapping(value = "/officerDashboard/allCheckedOKApplications")
	public List<Application> getAllCheckedOKApplications() {
		return officerService.getAllCheckedOKApplication();
	}

	// Get all checked Not OK applications
	@GetMapping(value = "/officerDashboard/allCheckedNotOKApplications")
	public List<Application> getAllCheckedNotOKApplications() {
		return officerService.getAllCheckedNotOKApplication();
	}

	// Get all completed applications
	@GetMapping(value = "/officerDashboard/allCompletedTranAcadApplications")
	public List<Application> getAllCompletedTranAcadApllications() {
		return officerService.getAllCompletedTranAcadApplication();
	}

	// Put application as accepted
	@PutMapping("/officerDashboard/allApplications/setNew/{applicationId}")
	public void setAcceptTranAcadApplication(@PathVariable("applicationId") int applicationId,
			Authentication authentication) throws AddressException, MessagingException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();
		officerService.acceptApplication(applicationId, officer);
		// send email to relevant officer
		officerService.sendEmailToList(officerService.getEmailListofOfficersByWCID(2),
				"Received accepted new application",
				"Dear Officer, <br><br>You have received accepted new Transcript/Academic Rank Certificate application.<br><br> Thank you ");
	}

	// Put application as rejected
	@PutMapping("/officerDashboard/allApplications/setReject/{applicationId}/{reason}")
	public void setRejectTranAcadApplication(@PathVariable("applicationId") int applicationId,
			@PathVariable("reason") String reason, Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();
		officerService.rejectApplication(applicationId, reason, officer);
	}

	// Put application as prepared
	// upload transcript and academic documents
	@PostMapping(value = "/officerDashboard/allApplications/uploadDocuments/", consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public void uploadDocuments(HttpServletResponse response, @RequestParam("applicationID") int applicationID,
			@RequestParam(value = "transcriptDocument", required = false) MultipartFile transcriptDocument,
			@RequestParam(value = "AcademicDocument", required = false) MultipartFile AcademicDocument,
			Authentication authentication) throws IOException {

		// get officer
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();

		try {
			// Upload transcript document data to database
			officerService.setTranscriptDocumentData(applicationID, transcriptDocument);
			// change status
			officerService.preparedT_Documents(applicationID, officer);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// Upload transcript document data to database
			officerService.setAcademicDocumentData(applicationID, AcademicDocument);
			// change status
			officerService.preparedA_Documents(applicationID, officer);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Put application as checked OK
	@PutMapping("/officerDashboard/allApplications/setCheckedOK/{applicationId}")
	public void setCheckedOKApplication(@PathVariable("applicationId") int applicationId,
			Authentication authentication) throws AddressException, MessagingException {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();
		
		officerService.checkedOKApplication(applicationId, officer);
		// send email to relevant officer
		officerService.sendEmailToList(officerService.getEmailListofOfficersByWCID(2),
				"Received Checked-OK application",
				"Dear Officer, <br><br>You have received checked OK application.<br>Application ID: "+applicationId+"<br><br> Thank you ");
	}
	// Put application as checked Not OK
	@PutMapping("/officerDashboard/allApplications/setCheckedNotOK/{applicationId}/{reason}")
	public void setCheckedNotOKApplication(@PathVariable("applicationId") int applicationId,
			@PathVariable("reason") String reason, Authentication authentication) throws AddressException, MessagingException {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();
		
		officerService.checkedNotOKApplication(applicationId, reason, officer);
		// send email to relevant officer
	    officerService.sendEmailToList(officerService.getEmailListofOfficersByWCID(2),
						"Received Checked-Not OK application",
						"Dear Officer, <br><br> The Application ID: "+applicationId+" is checked as NOT OK due to the follwing reason"
								+ "<br><br> Reason: "+reason+"<br><br> Thank you ");
	}

	// Put application as completed
	@PutMapping("/officerDashboard/allApplications/setCompleted/{applicationId}")
	public void setCompletedTranAcadApplication(@PathVariable("applicationId") int applicationId,
			Authentication authentication) throws AddressException, MessagingException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();
		officerService.completedApplication(applicationId, officer);

		// send email to relevant officer
		officerService.sendEmailToList(officerService.getEmailListofOfficersByWCID(1), "Received completed application",
				"Dear Officer, <br><br>You have received completed Transcript/Academic Rank Certificate application.<br><br> Thank you ");

	}

	// Put application as done
	@PutMapping("/officerDashboard/allApplications/setDone/{applicationId}")
	public void setDoneTranAcadApplication(@PathVariable("applicationId") int applicationId,
			Authentication authentication) throws MessagingException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String officer = officerService.getOfficer(userDetails.getUsername()).getFirstName();

		officerService.doneApplication(applicationId, officer);
	}

	// download application
	@GetMapping(value = "/officerDashboard/allApplications/{applicationId}")
	public void downloadApplication(@PathVariable("applicationId") int applicationId, HttpServletResponse response)
			throws DocumentException, IOException {

		officerService.downloadPDFApplication(applicationId, response);
	}

	// view application
	@GetMapping(value = "/officerDashboard/Applications/{applicationId}.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pdfReport(@PathVariable("applicationId") int applicationId) {

		ByteArrayInputStream bis = ApplicationPDFExporter.pdfDocument(officerService.getApplication(applicationId));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=application_" + applicationId + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

}
