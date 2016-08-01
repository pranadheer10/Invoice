package Invoice;

import java.util.*;

/**
 * Employee details are all shown here
 */
public class Employee {

	Collection<Project> projects;
	Project employee;
	/**
	 * This is the name of the employee
	 */
	private String Name;
	/**
	 * This is the role of the employee
	 */
	private String role;
	/**
	 * This shows the bill rate of the employee
	 */
	private String billRate;
	/**
	 * The username of the employee is this
	 */
	private String Username;
	/**
	 * This is the password for the employee
	 */
	private String password;

	public String getName() {
		// TODO - implement Employee.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Name
	 */
	public void setName(String Name) {
		// TODO - implement Employee.setName
		throw new UnsupportedOperationException();
	}

	public String getRole() {
		return this.role;
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public String getBillRate() {
		return this.billRate;
	}

	/**
	 * 
	 * @param billRate
	 */
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	public String getUsername() {
		// TODO - implement Employee.getUsername
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Username
	 */
	public void setUsername(String Username) {
		// TODO - implement Employee.setUsername
		throw new UnsupportedOperationException();
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}