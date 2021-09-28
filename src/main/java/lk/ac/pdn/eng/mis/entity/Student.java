package lk.ac.pdn.eng.mis.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("5")
public class Student extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String role = "STUDENT";
	
	@Column(unique = true)
	private String registrationNo;

	public Student() {
		super();
	}

	public Student(String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String regNo) {
		super(username, password, firstName, lastName, address, email, mobileNumber, loginStatus,role);
		this.registrationNo = regNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
}
