package lk.ac.pdn.eng.mis.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.pdn.eng.mis.entity.Student;
import lk.ac.pdn.eng.mis.service.StudentService;

@Controller
@RequestMapping("/studentDashboard")
public class StudentController {

	@Autowired
	private StudentService studentService;

	private Student student;

	// Get My Account details
	@GetMapping("")
	public ModelAndView getAccountDeatils(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());

		student = studentService.getStudent(userDetails.getUsername());
		//System.out.println("fname: " + student.getFirstName());
		model.addAttribute("first_name", student.getFirstName());
		model.addAttribute("last_name", student.getLastName());

		model.addAttribute("email", student.getEmail());
		return new ModelAndView("student/studentDashboard");
	}

	@RequestMapping("/myAccount")
	public String defectAccountDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		student = studentService.getStudent(userDetails.getUsername());

		model.addAttribute("first_name", student.getFirstName());
		model.addAttribute("last_name", student.getLastName());
		model.addAttribute("username", student.getUsername());
		model.addAttribute("address", student.getAddress());
		model.addAttribute("email", student.getEmail());
		model.addAttribute("mobile", student.getMobileNumber());
		model.addAttribute("registraionNo", student.getRegistrationNo());
	    return "student/MyAccount";
	}
}
