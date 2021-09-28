package lk.ac.pdn.eng.mis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rank", discriminatorType = DiscriminatorType.STRING)
@Table (name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique = true)
	private String username;
	private String password; 
	private String firstName;
	private String lastName;
	private String address;
	@Column(unique = true) /*Adding a unique constraint to the email to not allow user do multiple registration with same email id.*/
	private String email;
	private String mobileNumber;
	private String loginStatus = "NULL";
	private String role;
	
	public User() {
	}
	
	public User(String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.loginStatus = loginStatus;
		this.role = role;
	}


	public User(long id, String username, String password, String firstName, String lastName, String address,
			String email, String mobileNumber, String loginStatus, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.loginStatus = loginStatus;
		this.role = role;
	}


	public Long getId() {
	    return id;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


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


	public String getLoginStatus() {
		return loginStatus;
	}


	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
