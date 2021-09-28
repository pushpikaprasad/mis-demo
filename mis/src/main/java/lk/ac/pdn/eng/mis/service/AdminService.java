package lk.ac.pdn.eng.mis.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lk.ac.pdn.eng.mis.entity.Admin;
import lk.ac.pdn.eng.mis.entity.Ar;
import lk.ac.pdn.eng.mis.entity.Employee;
import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.entity.Student;
import lk.ac.pdn.eng.mis.entity.User;
import lk.ac.pdn.eng.mis.repository.AdminRepository;
import lk.ac.pdn.eng.mis.repository.ArRepository;
import lk.ac.pdn.eng.mis.repository.EmployeeRepository;
import lk.ac.pdn.eng.mis.repository.OfficerRepository;
import lk.ac.pdn.eng.mis.repository.StudentRepository;
import lk.ac.pdn.eng.mis.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ArRepository arRepository;

	@Autowired
	private OfficerRepository officerRepository;

	// create Admin account
	public String createAdmin(User user) {
		String status;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			adminRepository.save((Admin) user);
			status = "done";
		} catch (DataIntegrityViolationException e) {
			status = "error";
			System.out.println(e.getMessage());
		}
		return status;
	}

	// create Student account
	public String createStudent(Student s) {
		String status;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(s.getPassword());
			s.setPassword(encodedPassword);

			studentRepository.save(s);
			status = "done";
		} catch (DataIntegrityViolationException e) {
			status = "error";
			System.out.println(e.getMessage());
		}
		return status;
	}

	// create AR account
	public String createAr(User user) {
		String status;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			arRepository.save((Ar) user);
			status = "done";
		} catch (DataIntegrityViolationException e) {
			status = "error";
			System.out.println(e.getMessage());
		}
		return status;
	}

	// create Officer account
	/*public String createOfficer(User user) {
		String status;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			officerRepository.save((Officer) user);
			status = "done";
		} catch (DataIntegrityViolationException e) {
			status = "error";
			System.out.println(e.getMessage());
		}
		return status;
	}*/
	
	public String createOfficer(Officer officer ) {
		String status;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(officer.getPassword());
			officer.setPassword(encodedPassword);
			officerRepository.save(officer);
			status = "done";
		} catch (DataIntegrityViolationException e) {
			status = "error";
			System.out.println(e.getMessage());
		}
		return status;
	}

	// Get student list
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	// Get officer List
	public List<Officer> getOfficers() {
		return officerRepository.findAll();
	}

	// Get ar List
	public List<Ar> getAr() {
		return arRepository.findAll();
	}

	// Get admin
	public Admin getAdmin(String username) {
		return adminRepository.findByUsername(username);

	};

	// Update admin
	public void updateAdmin(Admin admin) {
		try {

			adminRepository.save(admin);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + " updateAdmin() gives null object!");
		}
	}

	// Reset user password
	public void setPassword(String username, String newPassword) {
		try {

			User user = userRepository.findByUsername(username);

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String decodedPassword = passwordEncoder.encode(newPassword);
			
			user.setPassword(decodedPassword);
			
			userRepository.save(user);
			
			String title = "Your account's password has been changed";
			String msg = "Dear User,<br><br>Your account's password in MIS of Dean's office has been changed.<br>Username: <b>"+username+"</b><br> Your new password is <b>"+newPassword+"</b><br><br>Thank you.";
			userService.sendEmailHTML(user.getEmail(), title, msg);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// find user by email
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//delete officer
	public void deleteOfficer(String email) {
		Officer officer = (Officer) getUserByEmail(email);
		userRepository.delete(officer);
		String title = "Your account has been deleted";
		String msg = "Dear user,\n\nYour account in MIS of Dean's office has been deleted." + "\n\nThank you.";
		userService.sendEmail(email, title, msg);
		
	}
	
	//delete student
	public void deleteStudent(String email) {
			Student student = (Student) getUserByEmail(email);
			userRepository.delete(student);
			String title = "Your account has been deleted";
			String msg = "Dear Student,\n\nYour account in MIS of Dean's office has been deleted." + "\n\nThank you.";
			userService.sendEmail(email, title, msg);
	}

	/********************************************
	 * Employee Details
	 ******************************************/
	// Get all employees
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public void createEmployee(Employee newEmployee) {
		try {
			employeeRepository.save(newEmployee);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteEmployee(String email) {
		Employee employee = employeeRepository.findEmployeeByEmail(email);
		try {
			employeeRepository.delete(employee);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setEmployeeDetailsbySheet(MultipartFile employeeExcel) {
		try {
		      List<Employee> employees = ExcelHelper.excelToEmployees(employeeExcel.getInputStream());
		      employeeRepository.saveAll(employees);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
	}

	public List<Employee> searchEmployee(String emNumber,String empSurname,String empDesig,String presentDivi, String type) {
		
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

	public InputStream downloadSearchEmployee(String emNumber,String empSurname,String empDesig,String presentDivi, String type) {
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

	public Officer getOfficerByEmail(String email) {
		Officer officerData = officerRepository.getOfficerByEmail(email);
		return officerData;
	}

	public void updateOfficer(Officer newOfficer) {
		officerRepository.save(newOfficer);
	}
	
}
