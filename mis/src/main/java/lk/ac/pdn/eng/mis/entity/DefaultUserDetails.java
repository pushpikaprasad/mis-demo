package lk.ac.pdn.eng.mis.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class DefaultUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	
	public DefaultUserDetails(User user2) {
		this.user = user2;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(4);

		  if (user.getRole().compareTo("ADMIN") == 0) {
		    authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		  }if (user.getRole().compareTo("AR") == 0) {
			    authList.add(new SimpleGrantedAuthority("ROLE_AR"));
		  }if (user.getRole().compareTo("OFFICER") == 0) {
			    authList.add(new SimpleGrantedAuthority("ROLE_OFFICER"));
		  }
		  else{
		    authList.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
		  }
		  return authList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return user.getFirstName()+ " "+ user.getLastName();
	}

	
}
