package lk.ac.pdn.eng.mis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.pdn.eng.mis.entity.Officer;
import lk.ac.pdn.eng.mis.entity.WorkCategory;
import lk.ac.pdn.eng.mis.service.OfficerService;

@Controller
@RequestMapping("/officerDashboard")
public class OfficerController {

	@Autowired
	private OfficerService officerService;

	private Officer officer; 
	
	@GetMapping("")
	public ModelAndView getAccountDeatils(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());

		officer = officerService.getOfficer(userDetails.getUsername());
		//System.out.println("fname: " +officer.getFirstName());
		model.addAttribute("first_name", officer.getFirstName());
		model.addAttribute("last_name", officer.getLastName());
		
		//set features
		WorkCategory w = new WorkCategory();
		String HTMLButtons = "";
		String workCategoryNumber = ""+officer.getWorkCategoryId();
		for(int i=0;i<workCategoryNumber.length();i++) {
			int n = Integer.parseInt(Character.toString(workCategoryNumber.charAt(i)));
			HTMLButtons +=  w.getWorkCategoryHTML(n);
		}
		model.addAttribute("workCategoryContent",HTMLButtons);
		

		return new ModelAndView("officer/officerDashboard");
	}
	
	@RequestMapping("/myAccount")
	public String defectAccountDetails(Authentication authentication,  Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		officer = officerService.getOfficer(userDetails.getUsername());

		model.addAttribute("first_name", officer.getFirstName());
		model.addAttribute("last_name", officer.getLastName());
		model.addAttribute("username", officer.getUsername());
		model.addAttribute("address", officer.getAddress());
		model.addAttribute("email", officer.getEmail());
		model.addAttribute("mobile", officer.getMobileNumber());
		model.addAttribute("nic", officer.getNIC());
	    return "officer/MyAccount";
	}
	
	@GetMapping("/Applications")
	public ModelAndView getApplicationDeatils(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//System.out.println("Username: " + userDetails.getUsername());

		officer = officerService.getOfficer(userDetails.getUsername());
		//System.out.println("fname: " +officer.getFirstName());
		model.addAttribute("first_name", officer.getFirstName());
		model.addAttribute("last_name", officer.getLastName());

		return new ModelAndView("officer/ApplicationsView");
	}
	
	@GetMapping("/accepted_transcript_academic_applications")
	public ModelAndView getAcceptedTranAcadAppliDetails(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		officer = officerService.getOfficer(userDetails.getUsername());
		model.addAttribute("first_name", officer.getFirstName());
		model.addAttribute("last_name", officer.getLastName());

		return new ModelAndView("officer/AcceptedTranAcaApplications");
		
	}
	//Check_transcript_academic_documents
	@GetMapping("/Check_transcript_academic_documents")
	public ModelAndView getCheckTranscriptAcademicDocuments(Authentication authentication, Model model) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		officer = officerService.getOfficer(userDetails.getUsername());
		model.addAttribute("first_name", officer.getFirstName());
		model.addAttribute("last_name", officer.getLastName());

		return new ModelAndView("officer/CheckTranscriptAcademicDocuments");
		
	}
	
}
