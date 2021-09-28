package lk.ac.pdn.eng.mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lk.ac.pdn.eng.mis.entity.Admin;
import lk.ac.pdn.eng.mis.entity.Ar;
import lk.ac.pdn.eng.mis.entity.Employee;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.entity.Student;
import lk.ac.pdn.eng.mis.entity.User;
import lk.ac.pdn.eng.mis.service.AdminService;

@RestController
public class RestAPIAdminController {

	@Autowired
	private AdminService adminService;

	// Get Student in JSON
	@GetMapping(value = "/adminDashboard/studentList")
	public List<Student> getStudents(Model model) {

		return adminService.getStudents();
	}

	// Add Student Details
	@PostMapping(value = "/adminDashboard/studentList/addstudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student newStudent) {
		adminService.createStudent(newStudent);
	}

	

	// Get Ar in JSON
	@GetMapping(value = "/adminDashboard/arList")
	public List<Ar> getAr(Model model) {
		return adminService.getAr();
	}

	// Add Ar Details
	@PostMapping(value = "/adminDashboard/arList/addar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAr(@RequestBody Ar newAr) {
		adminService.createAr(newAr);
	}

	// Get Admin details
	@GetMapping(value = "/adminDashboard/getAdmin")
	public Admin getAdmin(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return adminService.getAdmin(userDetails.getUsername());
	}

	// update Admin
	@PostMapping(value = "/adminDashboard/updateAdmin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAdmin(@RequestBody Admin editAdmin, Authentication authentication) {
		adminService.updateAdmin(editAdmin);
	}

	// reset password
	@PostMapping(value = "/adminDashboard/resetPassword", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public void resetPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword) {
		User user = adminService.getUserByEmail(email);
		adminService.setPassword(user.getUsername(), newPassword);
	}

	// delete Student
	@DeleteMapping("/adminDashboard/deleteStudent/{email}")
	public void deleteStudent(@PathVariable("email") String email) {
		adminService.deleteStudent(email);
	}

	/********************************************
	 * Officer Details
	 ******************************************/
	// Get officer in JSON
	@GetMapping(value = "/adminDashboard/officerList")
	public List<Officer> getOfficers(Model model) {
		return adminService.getOfficers();
	}
	
	// Get officer By Email
	@GetMapping(value = "/adminDashboard/officerList/{Email}")
	public Officer getOfficerByEmail(@PathVariable("Email") String email) {
		return adminService.getOfficerByEmail(email);
	}

	// Add Officer Details
	@PostMapping(value = "/adminDashboard/officerList/addofficer/{workcategoryID}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addOfficer(@RequestBody Officer newOfficer, @PathVariable("workcategoryID") String workcategoryID) {
		newOfficer.setWorkCategoryId(workcategoryID);
		adminService.createOfficer(newOfficer);
	}
	
	// Update Officer Details
	@PostMapping(value = "/adminDashboard/officerList/updateOfficer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addOfficer(@RequestBody Officer newOfficer) {
		adminService.updateOfficer(newOfficer);
	}

	// delete Officer
	@DeleteMapping("/adminDashboard/deleteOfficer/{email}")
	public void deleteOfficer(@PathVariable("email") String email) {
		adminService.deleteOfficer(email);
	}

	/********************************************
	 * Employee Details
	 ******************************************/
	// Get all employees
	@GetMapping(value = "/adminDashboard/employeeDetails")
	public List<Employee> getEmployees(Model model) {
		return adminService.getEmployees();
	}

	// Add Employee Details
	@PostMapping(value = "/adminDashboard/employeeDetails/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addEmployee(@RequestBody Employee newEmployee) {
		adminService.createEmployee(newEmployee);
	}

	// delete employee
	@DeleteMapping("/adminDashboard/employeeDetails/deleteEmployee/{email}")
	public void deleteEmployee(@PathVariable("email") String email) {
		adminService.deleteEmployee(email);
	}

	// Create employee accounts using excel sheet
	@PostMapping(value = "/adminDashboard/employeeDetails/employeeExcel", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public void submitApplication(HttpServletResponse response, @RequestParam("employeeExcel") MultipartFile employeeExcel) throws IOException {
		//Upload excel data to database
		adminService.setEmployeeDetailsbySheet(employeeExcel);
		
	}
	
	// search employee
	@GetMapping(value = "/adminDashboard/employeeDetails/searchEmployee/{emNumber}/{empSurname}/{empDesig}/{presentDivi}/{type}")
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
		  
		return adminService.searchEmployee(employeeNumber,surnameWithInitials,designation,presentDivision1,type);
	}
	
	// download searched employee
	@GetMapping(value = "/adminDashboard/employeeDetails/downloadSearchedEmployees/{emNumber}/{empSurname}/{empDesig}/{presentDivi}/{type}")
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
		    InputStreamResource file = new InputStreamResource(adminService.downloadSearchEmployee(employeeNumber,surnameWithInitials,designation,presentDivision1,type));

		    
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		        .body(file);
	}
}
