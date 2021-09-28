package lk.ac.pdn.eng.mis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lk.ac.pdn.eng.mis.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
				.antMatchers("/js/**", "/css/**", "/img/**", "*/icons/**", "/adminDashboard/css/**",
						"/adminDashboard/js/**", "/adminDashboard/img/**", "/adminDashboard/icons/**",
						"/studentDashboard/css/**", "/studentDashboard/js/**", "/studentDashboard/img/**",
						"/studentDashboard/icons/**", "/officerDashboard/css/**", "/officerDashboard/js/**",
						"/officerDashboard/img/**", "/officerDashboard/icons/**", "/paymentReceipts/**",
						"/officerDashboard/paymentReceipts/**", "/studentDashboard/paymentReceipts/**",
						"/clearenceForms/**", "/officerDashboard/clearenceForms/**",
						"/studentDashboard/Application/sendApplication", "/studentDashboard/clearenceForms/**",
						"/sendApplication/**",
						"/studentDashboard/downloadApplication/**", "/officerDashboard/downloadApplication/**")
				
				.permitAll().antMatchers("/studentDashboard/**").hasAnyRole("STUDENT").antMatchers("/adminDashboard/**")
				.hasAnyRole("ADMIN").antMatchers("/arDashboard/**").hasAnyRole("AR").antMatchers("/officerDashboard/**")
				.hasAnyRole("OFFICER").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.successHandler(successHandler).loginProcessingUrl("/login_success")
				.failureHandler(authenticationFailureHandler())// .failureUrl("/login?error=true")
				.failureUrl("/login_error").permitAll().and().logout().logoutSuccessUrl("/login.html")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler())
				.and().headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

}
