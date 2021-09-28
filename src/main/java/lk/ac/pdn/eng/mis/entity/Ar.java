package lk.ac.pdn.eng.mis.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Ar extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NIC;
	private final static String role = "AR";

	public Ar() {
		super();
	}

	public Ar(String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String nic) {
		super(username, password, firstName, lastName, address, email, mobileNumber, loginStatus,role);
		this.NIC = nic;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}
}
