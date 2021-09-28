package lk.ac.pdn.eng.mis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeDataId;
	private String employeeNumber;
	private String title;
	private String surnameWithInitials; // name
	private String namesDenotedByInitials;
	private String nic;
	private String designation;
	private String presentDivision1;
	//private String presentDivision2;
	//private String natureOfTheJob;	
	private String telephone;
	private String type;
	private String email;
	private String mobileNumber;
	private String address;
	//private String subject;
	
	public Employee(int employeeDataId, String employeeNumber, String title, String surnameWithInitials,
			String namesDenotedByInitials, String nic, String designation,
			String presentDivision1, String email, String mobileNumber, String telephone,
			String type, String address) {
		super();
		this.employeeDataId = employeeDataId;
		this.employeeNumber = employeeNumber;
		this.title = title;
		this.surnameWithInitials = surnameWithInitials;
		this.namesDenotedByInitials = namesDenotedByInitials;
		this.nic = nic;
		this.designation = designation;
		this.presentDivision1 = presentDivision1;
		//this.presentDivision2 = presentDivision2;
		//this.natureOfTheJob = natureOfTheJob;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.telephone = telephone;
		this.type = type;
		this.address = address;
		//this.subject = subject;
	}

	public Employee() {
		super();
	}

	public int getEmployeeDataId() {
		return employeeDataId;
	}

	public void setEmployeeDataId(int employeeDataId) {
		this.employeeDataId = employeeDataId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 

	public String getSurnameWithInitials() {
		return surnameWithInitials;
	}

	public void setSurnameWithInitials(String surnameWithInitials) {
		this.surnameWithInitials = surnameWithInitials;
	}

	public String getNamesDenotedByInitials() {
		return namesDenotedByInitials;
	}

	public void setNamesDenotedByInitials(String namesDenotedByInitials) {
		this.namesDenotedByInitials = namesDenotedByInitials;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPresentDivision1() {
		return presentDivision1;
	}

	public void setPresentDivision1(String presentDivision1) {
		this.presentDivision1 = presentDivision1;
	}

	/*
	 * public String getPresentDivision2() { return presentDivision2; }
	 * 
	 * public void setPresentDivision2(String presentDivision2) {
	 * this.presentDivision2 = presentDivision2; }
	 * 
	 * public String getNatureOfTheJob() { return natureOfTheJob; }
	 * 
	 * public void setNatureOfTheJob(String natureOfTheJob) { this.natureOfTheJob =
	 * natureOfTheJob; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * public String getSubject() { return subject; }
	 * 
	 * public void setSubject(String subject) { this.subject = subject; }
	 */
}
