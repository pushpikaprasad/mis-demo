package lk.ac.pdn.eng.mis.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4")
public class Officer extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NIC;
	private final static String role = "OFFICER";
	private String workCategoryId;
	
	public Officer() {
		super();
	}

	/*public Officer(String username, String password, String firstName, String lastName, String address, 
			String email, String mobileNumber, String loginStatus, String nic) {
		super(username, password, firstName, lastName, address, email, mobileNumber, loginStatus, role);
		this.NIC = nic;
	}*/
	
	public Officer(String username, String password, String firstName, String lastName, String address, 
			String email, String mobileNumber, String loginStatus, String nic, String wcid) {
		super(username, password, firstName, lastName, address, email, mobileNumber, loginStatus, role);
		this.NIC = nic;
		this.workCategoryId = wcid;
	}
	

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getWorkCategoryId() {
		return workCategoryId;
	}

	public void setWorkCategoryId(String workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	

}
