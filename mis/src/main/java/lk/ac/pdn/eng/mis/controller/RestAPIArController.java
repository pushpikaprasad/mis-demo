package lk.ac.pdn.eng.mis.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.entity.Ar;
import lk.ac.pdn.eng.mis.entity.Employee;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.service.ApplicationPDFExporter;
import lk.ac.pdn.eng.mis.service.ArService;

@RestController
public class RestAPIArController {
	
	@Autowired
	private ArService arService;
	
	/* APPLICATIONS */
	// Get all applications
		@GetMapping(value = "/arDashboard/allApplications")
		public List<Application> getAllApllications() {
			return arService.getAllTanAndAcaApps();
		}

		// Get all applications by Registration No
		@GetMapping(value = "/arDashboard/searchApplications/{registrationNo}")
		public List<Application> getApplicationByRegNo(@PathVariable("registrationNo") String registrationNo){
			String regNo = registrationNo.replaceAll("_", "/");
			return arService.getAllApplicationsByRegNo(regNo);
		}
		
		// Get all new applications
		@GetMapping(value = "/arDashboard/allNewApplications")
		public List<Application> getAllNewApllications() {
			return arService.getAllNewApplications();
		}

		// Get all accepted applications
		@GetMapping(value = "/arDashboard/allAcceptedApplications")
		public List<Application> getAllAcceptedTranAcadApllications() {
			return arService.getAllAcceptedApplication();
		}

		// Get all accepted applications
		@GetMapping(value = "/arDashboard/allCompletedTranAcadApplications")
		public List<Application> getAllCompletedTranAcadApllications() {
			return arService.getAllCompletedTranAcadApplication();
		}

		// Get all rejected applications
		@GetMapping(value = "/arDashboard/allRejectedApplications")
		public List<Application> getAllRejectedTranAcadApllications() {
			return arService.getAllRejectedApplication();
		}
		
		// download application
		@GetMapping(value = "/arDashboard/allApplications/{applicationId}")
		public void downloadApplication(@PathVariable("applicationId") int applicationId, HttpServletResponse response)
				throws DocumentException, IOException {

			arService.downloadPDFApplication(applicationId, response);
		}

		// view application
		@GetMapping(value = "/arDashboard/Applications/{applicationId}.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> pdfReport(@PathVariable("applicationId") int applicationId) {

			ByteArrayInputStream bis = ApplicationPDFExporter.pdfDocument(arService.getApplication(applicationId));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		
		
		/* EMPLOYEES */
		
		// Get all employees
		@GetMapping(value = "/arDashboard/employeeDetails")
		public List<Employee> getEmployees(Model model) {
			return arService.getEmployees();
		}
		
		// search employee
		@GetMapping(value = "/arDashboard/employeeDetails/searchEmployee/{emNumber}/{empSurname}/{empDesig}/{presentDivi}/{type}")
		public List<Employee> searchEmployees(@PathVariable("emNumber") String employeeNumber,
				@PathVariable("empSurname") String surnameWithInitials,
				@PathVariable("empDesig") String designation,
				@PathVariable("presentDivi") String presentDivision1,
				@PathVariable("type") String type){
			
			  if(employeeNumber.equals("NA")) { employeeNumber = ""; }
			  if(surnameWithInitials.equals("NA")) { surnameWithInitials = ""; }
			  if(designation.equals("NA")) { designation = ""; }
			  if(presentDivision1.equals("NA")) { presentDivision1 = ""; }
			  if(type.equals("NA")) { type = ""; }
			
			return arService.searchEmployee(employeeNumber,surnameWithInitials,designation,presentDivision1,type);
		}
		
		// download searched employee
		@GetMapping(value = "/arDashboard/employeeDetails/downloadSearchedEmployees/{emNumber}/{empSurname}/{empDesig}/{presentDivi}/{type}")
		public ResponseEntity<Resource> downloadSearchedEmployees(@PathVariable("emNumber") String employeeNumber,
				@PathVariable("empSurname") String surnameWithInitials,
				@PathVariable("empDesig") String designation,
				@PathVariable("presentDivi") String presentDivision1,
				@PathVariable("type") String type){
			
			  if(employeeNumber.equals("NA")) { employeeNumber = ""; }
			  if(surnameWithInitials.equals("NA")) { surnameWithInitials = ""; }
			  if(designation.equals("NA")) { designation = ""; }
			  if(presentDivision1.equals("NA")) { presentDivision1 = ""; }
			  if(type.equals("NA")) { type = ""; }
			  
			 
			 String filename = "Employee details.xlsx";
			    InputStreamResource file = new InputStreamResource(arService.downloadSearchEmployee(employeeNumber,surnameWithInitials,designation,presentDivision1,type));

			    
			    return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
			    
			    
		}
		
		/* MY ACCOUNT */
		// Get Ar
		@GetMapping(value = "/arDashboard/getAr")
		public Ar getAr(Authentication authentication) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			return arService.getAr(userDetails.getUsername());
		}
		
		// update ar
		@PostMapping(value = "/arDashboard/updateAr", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateOfficer(@RequestBody Ar editAr, Authentication authentication) {
			arService.updateAr(editAr);

		}
}
