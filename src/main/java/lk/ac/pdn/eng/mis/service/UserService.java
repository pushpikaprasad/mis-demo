package lk.ac.pdn.eng.mis.service;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lk.ac.pdn.eng.mis.entity.DefaultUserDetails;
import lk.ac.pdn.eng.mis.entity.User;
import lk.ac.pdn.eng.mis.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	    
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		//Optional<User> user = userRepository.findById(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new DefaultUserDetails(user);
	}

	
	public boolean isUserDoesNotExists(String username) {
		User user = userRepository.findByUsername(username);
		boolean isUser;
		if(user == null) {
			isUser = true;
		}else {
			isUser = false;
		}
		return isUser;
	}
	
	//send email
	public void sendEmail(String toSend, String title, String messageText){
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(toSend);
		msg.setSubject(title);
        msg.setText(messageText);
        javaMailSender.send(msg);
    }
	
	//send email with HTML
	public void sendEmailHTML(String toSend, String title, String message) throws MessagingException{
		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom("cp.eng.pdn@gmail.com");
		helper.setTo(toSend);
		helper.setSubject(title);
		helper.setText(message,true);
		javaMailSender.send(msg);
	}
	
	// send pdf attachment

	public void sendEmailWithPDF(String toSend, String title, String messageText, int id) throws MessagingException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom("cp.eng.pdn@gmail.com");
		helper.setTo(toSend);

		URL fileURL = null;
		try {
			fileURL = new URL("http://localhost:8080/studentDashboard/downloadApplication/" + id);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}  
		URLDataSource file = new URLDataSource(fileURL);
		helper.addAttachment("Application-" + id + ".pdf", file);
		helper.setSubject(title);
		helper.setText(messageText);
		javaMailSender.send(msg);

	}
	
	//find user by email
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	public void sendEmailToList(InternetAddress[] internetAddresses, String title, String message) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom("cp.eng.pdn@gmail.com");
		helper.setTo(internetAddresses);
		helper.setSubject(title);
		helper.setText(message,true);
		javaMailSender.send(msg);
		
	}


	public List<User> getEmailListofOfficersByWCID(int i) {
		//return userRepository.getEmailListofOfficersByWCID(i);
		return userRepository.findByWorkCategoryIdLike(String.valueOf(i));
	}
	
}

