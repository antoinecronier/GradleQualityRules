package entities;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private String name;
	private int security_level;
	private List<User> users;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the security_level
	 */
	public int getSecurity_level() {
		return security_level;
	}
	/**
	 * @param security_level the security_level to set
	 */
	public void setSecurity_level(int security_level) {
		this.security_level = security_level;
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role(String name, int security_level, List<User> users) {
		super();
		this.name = name;
		this.security_level = security_level;
		this.users = users;
	}

	public Role(){
		this.users = new ArrayList<User>();
	}
}
