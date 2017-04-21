package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String firstname;
	private String lastname;
	private Boolean isActive;
	private int security_code;
	private List<Role> roles;

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the security_code
	 */
	public int getSecurity_code() {
		return security_code;
	}
	/**
	 * @param security_code the security_code to set
	 */
	public void setSecurity_code(int security_code) {
		this.security_code = security_code;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(String firstname, String lastname, Boolean isActive,
			int security_code, List<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.isActive = isActive;
		this.security_code = security_code;
		this.roles = roles;
	}

	public User() {
		this.roles = new ArrayList<Role>();
	}
}
