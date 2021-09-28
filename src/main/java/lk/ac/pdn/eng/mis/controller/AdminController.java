package lk.ac.pdn.eng.mis.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.pdn.eng.mis.entity.Admin;
import lk.ac.pdn.eng.mis.repository.AdminRepository;
import lk.ac.pdn.eng.mis.service.AdminService;

@Controller
@RequestMapping("/adminDashboard")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminService adminService;
	
	private Admin admin;
	
	//Get My Account details
	@GetMapping("")
	public ModelAndView getAccountDeatils(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());
		
		admin = adminRepository.findByUsername(userDetails.getUsername());
		//System.out.println("fname: " + admin.getFirstName());
		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
		
		return new ModelAndView("admin/adminDashboard");
	}
	
	
	@RequestMapping("/students")
	public String defectStudentDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());
		
		admin = adminRepository.findByUsername(userDetails.getUsername());
		//System.out.println("fname: " + admin.getFirstName());
		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
	    return "admin/StudentAccounts";
	}
	
	@RequestMapping("/officers")
	public String defectOfficerDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());
		
		admin = adminRepository.findByUsername(userDetails.getUsername());
		//System.out.println("fname: " + admin.getFirstName());
		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
	    return "admin/OfficerAccounts";
	}
	
	@RequestMapping("/ar")
	public String defectArDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());
		
		admin = adminRepository.findByUsername(userDetails.getUsername());
		//System.out.println("fname: " + admin.getFirstName());
		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
	    return "admin/ArAccounts";
	}
	
	@RequestMapping("/employees")
	public String defectEmployeeDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());
		
		admin = adminRepository.findByUsername(userDetails.getUsername());
		//System.out.println("fname: " + admin.getFirstName());
		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
	    return "admin/EmployeeDetails";
	}
	
	@RequestMapping("/myAccount")
	public String defectAccountDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		admin = adminRepository.findByUsername(userDetails.getUsername());

		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
		model.addAttribute("username", admin.getUsername());
		model.addAttribute("address", admin.getAddress());
		model.addAttribute("email", admin.getEmail());
		model.addAttribute("mobile", admin.getMobileNumber());
		model.addAttribute("nic", admin.getNIC());
	    return "admin/MyAccount";
	}
	
	@GetMapping("/resetPassword")
	public String resetPasswordPage(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		admin = adminRepository.findByUsername(userDetails.getUsername());

		model.addAttribute("first_name", admin.getFirstName());
		model.addAttribute("last_name", admin.getLastName());
		model.addAttribute("username", admin.getUsername());
		model.addAttribute("address", admin.getAddress());
		model.addAttribute("email", admin.getEmail());
		model.addAttribute("mobile", admin.getMobileNumber());
		model.addAttribute("nic", admin.getNIC());
	    return "admin/resetPassword";
	}
}
