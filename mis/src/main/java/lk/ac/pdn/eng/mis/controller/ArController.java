package lk.ac.pdn.eng.mis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.pdn.eng.mis.entity.Ar;
import lk.ac.pdn.eng.mis.entity.WorkCategory;
import lk.ac.pdn.eng.mis.service.ArService;

@Controller
@RequestMapping("/arDashboard")
public class ArController {
	
	@Autowired
	private ArService arService;
	
	private Ar ar;
	
	@GetMapping("")
	public ModelAndView getAccountDeatils(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		ar = arService.getAr(userDetails.getUsername());
		model.addAttribute("first_name", ar.getFirstName());
		model.addAttribute("last_name", ar.getLastName());
		
		return new ModelAndView("ar/arDashboard");
	}
	
	@GetMapping("/Applications")
	public ModelAndView getApplicationDeatils(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		ar = arService.getAr(userDetails.getUsername());
		model.addAttribute("first_name", ar.getFirstName());
		model.addAttribute("last_name", ar.getLastName());

		return new ModelAndView("ar/ApplicationsView");
	}
	
	@RequestMapping("/employees")
	public String defectEmployeeDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		ar = arService.getAr(userDetails.getUsername());
		model.addAttribute("first_name", ar.getFirstName());
		model.addAttribute("last_name", ar.getLastName());
		
	    return "ar/EmployeeDetails";
	}
	
	@RequestMapping("/myAccount")
	public String defectAccountDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		ar = arService.getAr(userDetails.getUsername());

		model.addAttribute("first_name", ar.getFirstName());
		model.addAttribute("last_name", ar.getLastName());
		model.addAttribute("username", ar.getUsername());
		model.addAttribute("address", ar.getAddress());
		model.addAttribute("email", ar.getEmail());
		model.addAttribute("mobile", ar.getMobileNumber());
		model.addAttribute("nic", ar.getNIC());
	    return "ar/MyAccount";
	}
	
	

}
