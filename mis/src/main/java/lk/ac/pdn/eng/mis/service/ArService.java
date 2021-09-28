package lk.ac.pdn.eng.mis.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.DocumentException;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.entity.Ar;
import lk.ac.pdn.eng.mis.entity.Employee;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.repository.ArRepository;
import lk.ac.pdn.eng.mis.repository.EmployeeRepository;

@Service
public class ArService {

	@Autowired
	private ArRepository arRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationService applicationService;

	// get AR
	public Ar getAr(String username) {
		return arRepository.getArByUsername(username);
	}

	/* APPLICATION PROCESS */

	// Get all transcript/academic rank certificate applications
	public List<Application> getAllTanAndAcaApps() {
		return applicationService.getApplications();
	}

	// Get all new applications
	public List<Application> getAllNewApplications() {
		return applicationService.getApplicationByStatus("new");
	}

	// Get all accepted applications
	public List<Application> getAllAcceptedApplication() {
		return applicationService.getApplicationByStatus("accepted");
	}

	// Get all completed applications
	public List<Application> getAllCompletedTranAcadApplication() {
		return applicationService.getApplicationByStatus("completed");
	}

	// Get all rejected applications
	public List<Application> getAllRejectedApplication() {
		return applicationService.getApplicationByStatus("rejected");
	}

	// View Application
	public Application getApplication(int id) {
		return applicationService.getApplicationByID(id);
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

	/* EMPLOYEE */
	// Get all employees
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public List<Employee> searchEmployee(String emNumber, String empSurname, String empDesig, String presentDivi, String type) {
		if(emNumber.isEmpty()) {
			emNumber = null;
		}
		if(empSurname.isEmpty()) {
			empSurname = null;
		}
		if(empDesig.isEmpty()) {
			empDesig = null;
		}
		if(presentDivi.isEmpty()) {
			presentDivi = null;
		}
		if(type.isEmpty()) {
			type = null;
		}
		
		return employeeRepository.findAllByInputString(emNumber, empSurname, empDesig, presentDivi, type);
	}

	public InputStream downloadSearchEmployee(String emNumber, String empSurname, String empDesig, String presentDivi,String type) {
		List<Employee> employee;

		if(emNumber.isEmpty()) {
			emNumber = null;
		}
		if(empSurname.isEmpty()) {
			empSurname = null;
		}
		if(empDesig.isEmpty()) {
			empDesig = null;
		}
		if(presentDivi.isEmpty()) {
			presentDivi = null;
		}
		if(type.isEmpty()) {
			type = null;
		}
		
		employee = employeeRepository.findAllByInputString(emNumber, empSurname, empDesig, presentDivi, type);
		
	    ByteArrayInputStream in = ExcelHelper.employeesToExcel(employee);
	    return in;
	}

	// update AR account
	public void updateAr(Ar editAr) {
		try {

			arRepository.save(editAr);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + " updateAr() gives null object!");
		}
	}

	public List<Application> getAllApplicationsByRegNo(String regNo) {
		return applicationService.getApplicationByRegNo(regNo);
	}

}
