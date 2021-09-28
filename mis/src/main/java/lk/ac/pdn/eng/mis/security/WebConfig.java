package lk.ac.pdn.eng.mis.security;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * registry.addResourceHandler("/pdfs/**")
		 * .addResourceLocations("/WEB-INF/pdfs/");
		 */
		registry.addResourceHandler("/css/**", "/sendApplication/css/**", "/studentDashboard/css/**","/arDashboard/css/**",
				"/adminDashboard/css/**", "/officerDashboard/css/**")
				.addResourceLocations("/WEB-INF/views/assets/css/");
		registry.addResourceHandler("/js/**", "/sendApplication/js/**", "/studentDashboard/js/**", "/arDashboard/js/**",
				"/adminDashboard/js/**", "/officerDashboard/js/**").addResourceLocations("/WEB-INF/views/assets/js/");
		registry.addResourceHandler("/img/**", "/sendApplication/img/**", "/studentDashboard/img/**", "/arDashboard/img/**",
				"/adminDashboard/img/**", "/officerDashboard/img/**")
				.addResourceLocations("/WEB-INF/views/assets/img/");
		registry.addResourceHandler("/icons/**", "/sendApplication/icons/**", "/studentDashboard/icons/**","/arDashboard/icons/**",
				"/adminDashboard/icons/**", "/officerDashboard/icons/**")
				.addResourceLocations("/WEB-INF/views/assets/icons/");
		registry.addResourceHandler("/paymentReceipts/**", "/sendApplication/paymentReceipts/**",
				"/officerDashboard/paymentReceipts/**", "/studentDashboard/paymentReceipts/**")
				.addResourceLocations("/WEB-INF/views/files/paymentReceipts/");
		registry.addResourceHandler("/paymentReceipts2/**", "/sendApplication/paymentReceipts2/**",
				"/officerDashboard/paymentReceipts/**", "/studentDashboard/paymentReceipts/**")
				.addResourceLocations("/WEB-INF/views/files/paymentReceipts2/");
		registry.addResourceHandler("/clearenceForms/**", "/sendApplication/clearenceForms/**",
				"/officerDashboard/clearenceForms/**", "/studentDashboard/clearenceForms/**")
				.addResourceLocations("/WEB-INF/views/files/clearenceForms/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/WEB-INF/views/assets/img//favicon.ico");
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("cp.eng.pdn@gmail.com");
		mailSender.setPassword("kmaifhsfsstbgeaw");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
}
