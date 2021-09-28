package lk.ac.pdn.eng.mis.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NIC;
	private final static String role = "ADMIN";

	public Admin() {
		super();
	}

	public Admin(String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String nic) {
		super(username, password, firstName, lastName, address, email, mobileNumber, loginStatus, role);
		this.NIC = nic;
	}
	
	public Admin(long id, String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String role, String nIC) {
		super(id, username, password, firstName, lastName, address, email, mobileNumber, loginStatus, role);
		NIC = nIC;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}
	
	

}
