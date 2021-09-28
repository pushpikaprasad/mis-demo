package lk.ac.pdn.eng.mis.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.pdn.eng.mis.entity.User;
import lk.ac.pdn.eng.mis.repository.UserRepository;

@Controller
@RequestMapping
public class AppController{
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "login"; 
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login_error", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("loginError", "Username or Password is wrong!");
	    return "login";
	}
	
	@RequestMapping("/login_success")
	public void login(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletRequest request)  {
		@SuppressWarnings("unchecked")
		List<String> userLogin = (List<String>) request.getSession().getAttribute("USER_SESSION");
		if (userLogin == null) {
			userLogin = new ArrayList<>();
	        request.getSession().setAttribute("USER_SESSION", userLogin);
	    }
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "signup_form";
	}
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user") @Valid User user, HttpServletRequest request,  Model model) {
		//System.out.println(user.getPassword());
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(user.getPassword());
		    
		    //System.out.println(encodedPassword);
		    user.setPassword(encodedPassword);
			userRepository.save(user);
			return "register_success";
		}catch(DataIntegrityViolationException e) {
			model.addAttribute("userError", e.getMessage());
			//System.out.println(e.getMessage());
		}
		return "signup_form";	
	}
	
	@RequestMapping("/studentDashboard")
	public ModelAndView studentDashboard() {
		return new ModelAndView("student/studentDashboard");
	}
	
	@RequestMapping("/adminDashboard")
	public ModelAndView adminDashboard() {
		return new ModelAndView("admin/adminDashboard");
		
	}
	
	@RequestMapping("/officerDashboard")
	public ModelAndView officerDashboard() {
		return new ModelAndView("officer/officerDashboard");
	}
	
	@RequestMapping("/arDashboard")
	public ModelAndView arDashboard() {
		return new ModelAndView("ar/arDashboard");
	}
	
	/*APIs for common use*/
	@RequestMapping("/sendApplication")
	public ModelAndView sendApplication() {
		return new ModelAndView("common/sendApplication");
	}

}
